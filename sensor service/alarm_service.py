import requests
import time
from playsound import playsound
from pygame import mixer
import json
from datetime import datetime, timedelta

REST_API_ALARM_URL = "http://localhost:8080/api/v1/wecker/configurations/"  # Ihre REST-API-URL hier einfügen
REST_API_PRESENCE_URL = "http://localhost:8080/api/v1/wecker/sensor/presence/logs/last"  # Ihre REST-API-URL hier einfügen
MP3_FILE_PATH = "alarm2.mp3"  # Pfad zur MP3-Datei hier einfügen

def get_next_alarm():
    response = requests.get(REST_API_ALARM_URL)
    return response.json()

def get_alarm_by_id(alarm_id):
    response = requests.get(REST_API_ALARM_URL+"/"+str(alarm_id))
    return response.json()

def get_presence_json():
    response = requests.get(REST_API_PRESENCE_URL)
    return response.json()

def get_presence():
    response = requests.get(REST_API_PRESENCE_URL)
    print("presence:",response.json())
    return response.json()["status"]

def check_alarm_should_play(alarm):
    alarm1 = get_alarm_by_id(alarm["id"])
    if len(alarm1) < 1: return False
    return alarm1["active"] == True

def play_alarm(alarm):
    print("start alarm")
    mixer.init()
    mixer.music.load(MP3_FILE_PATH)
    mixer.music.play()
    while check_alarm_should_play(alarm) and get_presence():
        time.sleep(1)
        print("playing")
        print("alarm:",check_alarm_should_play(alarm))
        print("presence:",get_presence())

        if not mixer.music.get_busy():
            mixer.music.play()
    print("stop playing")
    mixer.music.stop()
    return

def find_next_active_alarm(json_string):
    alarms = json_string #json.loads(json_string)

    now = datetime.now().replace(second=0, microsecond=0)
    next_alarm = None
    min_time_difference = float('1e100')

    for alarm in alarms:
        if alarm["active"]:
            if "alarmDate" in alarm and alarm["alarmDate"]:
                alarm_datetime = datetime.strptime(alarm["alarmDate"] + " " + alarm["alarmTime"], "%Y-%m-%d %H:%M").replace(second=0, microsecond=0)
            elif "days" in alarm and any(day["active"] for day in alarm["days"]):
                # Wenn kein Datum, aber mindestens ein aktiver Wochentag
                alarm_datetime = datetime.combine(now.date(), datetime.strptime(alarm["alarmTime"], "%H:%M").time()).replace(second=0, microsecond=0)
                # Finde den nächsten aktiven Wochentag
                for day in alarm["days"]:
                    if day["active"]:
                        days_until_next_day = (day["id"] - (now.weekday()+1) + 7) % 7
                        alarm_datetime += timedelta(days=days_until_next_day)
            else:
                # Wenn weder Datum noch Wochentag gegeben sind (um jeden Tag zu klingeln)
                alarm_datetime = datetime.combine(now.date(), datetime.strptime(alarm["alarmTime"], "%H:%M").time()).replace(second=0, microsecond=0)

            if alarm_datetime >= now:
                print(alarm_datetime, ">",now)
                time_difference = alarm_datetime - now

                if time_difference.total_seconds() < min_time_difference:
                    next_alarm = alarm
                    min_time_difference = time_difference.total_seconds()

                    # Füge das aktuelle Datum zum Alarm hinzu, wenn kein Datum vorhanden ist
                    if "alarmDate" not in next_alarm or not next_alarm["alarmDate"]:
                        next_alarm["alarmDate"] = now.strftime("%Y-%m-%d")

    return next_alarm

def main():
    while True:
        #alarm = get_next_alarm()
        print(requests.get(REST_API_ALARM_URL).json())
        alarm = find_next_active_alarm(requests.get(REST_API_ALARM_URL).json())
        current_time = time.strftime("%H:%M")
        print(current_time)
        print("NEXT ALARM:",alarm)

        alarm_id = alarm["id"]
        alarm_time = alarm["alarmTime"]
        alarm_status = alarm["active"]

        alarm_datetime = datetime.strptime(alarm["alarmDate"] + " " + alarm["alarmTime"], "%Y-%m-%d %H:%M").replace(second=0, microsecond=0)
        time_until_alarm = alarm_datetime - datetime.now().replace(second=0, microsecond=0)
        print(time_until_alarm)

        if alarm_time == current_time and alarm_status == True:
            if get_presence():
                play_alarm(alarm)

        time.sleep(10) #60 # Warten Sie eine Minute, bevor Sie die nächste Anfrage senden

if __name__ == "__main__":
    main()
