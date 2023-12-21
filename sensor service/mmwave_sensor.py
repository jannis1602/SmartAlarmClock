import serial
import json
import requests
import time
import yaml

MESSAGE_HEAD1 = 0x53       #Data frame header1
MESSAGE_HEAD2 = 0x59       #Data frame header2
MESSAGE_END1  = 0x54       #End1 of data frame
MESSAGE_END2  = 0x43       #End2 of data frame
HUMANSTATUS   = 0x80       #Human Presence Information
HUMANEXIST    = 0x01       #Presence of the human body
HUMANMOVE     = 0x02       #Human movement information
HUMANSIGN     = 0x03       #Body Signs Parameters
HUMANDIRECT   = 0x0B       #Human movement trends
SOMEBODY      = 0x01       #Somebody move
NOBODY        = 0x00       #No one here
NONE          = 0x00
SOMEBODY_STOP = 0x01       #Somebody stop
SOMEBODY_MOVE = 0x02       #Somebody move
CA_CLOSE      = 0x01       #Someone approaches
CA_AWAY       = 0x02       #Some people stay away
DETAILSTATUS  = 0x08       #Underlying parameters of the human state
DETAILINFO    = 0x01       #Detailed data on the state of human movement
DETAILDIRECT  = 0x06       #Human movement trends
DETAILSIGN    = 0x07       #Body Signs Parameters
SOMEONE       = 0x01       #There are people
NOONE         = 0x02       #No one
NOTHING       = 0x03       #No message
SOMEONE_STOP  = 0x04       #Somebody stop
SOMEONE_MOVE  = 0x05       #Somebody move
HUMANPARA     = 0x06       #Body Signs Parameters
SOMEONE_CLOSE = 0x07       #Someone approaches
SOMEONE_AWAY  = 0x08       #Some people stay away
DETAILMESSAGE = 0x09       #Underlying parameters of the human state

# Existence energy value: There are
# electromagnetic waves in the environment,
# and the electromagnetic wave frequency
# changes less when there is no one
# around. When there is a person in the
# space, the overall electromagnetic wave
# reflection will float weakly due to the slight
# movement caused by breathing (chest
# breathing).

# Stationary distance: The module detects
# the straight-line distance of human
# breathing, which is usually no more than 3
# meters.

# Motion energy value: The amplitude value
# of motion causes different electromagnetic
# wave frequency changes.
# Motion distance: Detects the distance of
# the moving target.

# Motion speed: Real-time judgment of the
# speed of the moving target; the speed is
# positive (0x01-0x09) when approaching
# the radar and negative (0x0b-0x14) when
# moving away. When there is no motion
# speed, the value is 0a (0m/s), and the
# speed level progresses in 0.5m/s
# increments, such as 0x0b is 0+0.5m/s;
# 0x09 is 0-0.5m/s

last_status = 1

def read_config():
    try:
        with open("config.yaml", "r") as file:
            config = yaml.safe_load(file)
            if config is None:
                raise Exception("Empty configuration file")
    
        #API_URL = config["api_url"]

        if "api_url" in config:
            API_URL = config["api_url"]
        else:
            print("Fehler: 'api_url' fehlt in der Konfiguration.")

        if "serial_port" in config:
            SERIAL_PORT = config["serial_port"]
        else:
            print("Fehler: 'serial_port' fehlt in der Konfiguration.")

        if "baud_rate" in config:
            BAUD_RATE = config["baud_rate"]
        else:
            print("Fehler: 'baud_rate' fehlt in der Konfiguration.")

        # if "listen_port" in config:
        #     LISTEN_PORT = config["listen_port"]
        #     if not isinstance(LISTEN_PORT, int):
        #         print("Fehler: 'listen_port' sollte eine Ganzzahl sein.")
        # else:
        #     print("Fehler: 'listen_port' fehlt in der Konfiguration.")

        return config
    
    except FileNotFoundError:
        print("Die Konfigurationsdatei existiert nicht. Eine Beispielskonfiguration wird erstellt.")
    default_config = {
        "api_url": "localhost",
        "serial_port": "dev/ttyS0",
        "baud_rate": 115200,
        "motion_trigger_value": 10
    }    
    with open("config.yaml", "w") as file:
        yaml.dump(default_config, file, default_flow_style=False)
    return default_config


def send_to_api(status):
    data = {
        "areaId": 1, # immer 1
        "statusId": status, # 1 oder 2
        "timestamp": int(time.time()) # aktuelle Unix-Zeit
        }
    json_data = json.dumps(data)
    response = requests.post('http://localhost:8080/api/v1/wecker/sensor/presence/logs', data=json_data)
    print('Status Code:', response.status_code)
    print('Response:', response.text)



def readData(data, motion_trigger_value):
    global last_status
    control = data[0]
    command = data[1]
    # print("control: ", control)
    # print("command: ", command)
    if control == 8:
        if command == 1 :
            data = data[4:]
            data = data[:-1]
            # print("new Data: ", data)
            existence_energy_value = data[0] # 0-250
            static_distance = data[1] # 1-6
            motion_energy_value = data[2] # 0-250
            motion_distance = data[3] # 1-8
            motion_speed = data[4] #1-14

            # print("existence_energy_value =", existence_energy_value)
            # print("static_distance =", static_distance)
            # print("motion_energy_value =", motion_energy_value)
            # print("motion_distance =", motion_distance)
            # print("motion_speed =", motion_speed)

            status = 1
            if(motion_energy_value > motion_trigger_value):
                status = 2

            if(last_status != status): 
                send_to_api(status)
                print("change: ",status)
                last_status = status


def read_serial_data(port, baudrate, motion_trigger_value):
    ser = serial.Serial(port, baudrate)
    start_sequence = [0x53, 0x59]  # Startsequenz
    end_sequence = [0x54, 0x43]    # Endsequenz
    buffer = []  # Puffer für die empfangenen Daten

    try:
        while True:
            byte = ser.read(1)  # Ein Byte von der seriellen Schnittstelle lesen
            if byte:
                buffer.append(byte[0])
                #if buffer[-len(start_sequence):] == start_sequence:
                    #print("Startsequenz erkannt")
                if buffer[-len(end_sequence):] == end_sequence:
                    #print("Endsequenz erkannt")
                    received_data = buffer[len(start_sequence):-len(end_sequence)]
                    #print("Empfangene Daten:", received_data) 

                    readData(received_data, motion_trigger_value)                   
                    buffer = [] # Puffer leeren

    except KeyboardInterrupt:
        print("Programm durch Benutzer unterbrochen")
    finally:
        ser.close()

if __name__ == "__main__":
    config = read_config()

    API_URL = config["api_url"]
    SERIAL_PORT = config["serial_port"]
    BAUD_RATE = config["baud_rate"]
    MOTION_TRIGGER_VALUE = config["motion_trigger_value"]

    print(API_URL, SERIAL_PORT, BAUD_RATE)

    #serial_port = "COM10"
    #baud_rate = 115200

    read_serial_data(SERIAL_PORT, BAUD_RATE, MOTION_TRIGGER_VALUE)


