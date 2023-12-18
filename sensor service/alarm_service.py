import requests
import time
from playsound import playsound
from pygame import mixer

REST_API_ALARM_URL = "http://127.0.0.1:5000/alarm"  # Ihre REST-API-URL hier einfügen
REST_API_PRESENCE_URL = "http://127.0.0.1:5000/presence"  # Ihre REST-API-URL hier einfügen
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
    return response.json()["status"]

def check_alarm_should_play(alarm):
    alarm1 = get_alarm_by_id(alarm["id"])
    return alarm1["status"] == True

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


def main():
    while True:
        alarm = get_next_alarm()
        current_time = time.strftime("%H:%M")
        print(current_time)
        print(alarm)

        alarm_id = alarm["id"]
        alarm_time = alarm["alarm_time"]
        alarm_status = alarm["status"]

        if alarm_time == current_time and alarm_status == True:
            if get_presence():
                play_alarm(alarm)

        time.sleep(10) #60 # Warten Sie eine Minute, bevor Sie die nächste Anfrage senden

if __name__ == "__main__":
    main()
