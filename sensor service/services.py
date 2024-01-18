import time

import alarm_service
import mmwave_sensor


def handleAlarms():
    alarms = alarm_service.getAllAlarms()
    alarm = alarm_service.find_next_active_alarm(alarms)

    if alarm_service.shouldRing(alarm):
        alarm_service.playAlarm()
    else:
        alarm_service.stopAlarm()

def handleSensor():
    mmwave_sensor.readDataOnce()
    pass


def main():
    while True:
        handleSensor()
        handleAlarms()
        time.sleep(0.5)

main()