import PySimpleGUI as sg
from flask import Flask, jsonify

app = Flask(__name__)
alarm_active = True
alarm_time = "12:30"
presence = False

def create_gui():
    global alarm_active, alarm_time, presence
    # Definieren Sie das Layout des Fensters
    layout = [
    [sg.Button("Presence True"),sg.Button("Presence False")],
    [sg.Input(key="-ALARM_TIME-"), sg.Button("Set Alarm")],
    [sg.Button("Alarm True"),sg.Button("Alarm False")]
    ]

    # Erstellen Sie das Fenster
    window = sg.Window("Window Title", layout)

    # Hauptereignisschleife
    while True:
        event, values = window.read()
        if event == sg.WINDOW_CLOSED:
            break
        elif event == "Presence True":
            presence = True
        elif event == "Presence False":
            presence = False
        elif event == "Alarm True":
            alarm_active = True
        elif event == "Alarm False":
            alarm_active = False
        elif event == "Set Alarm":
            print("Alarm set to: ", values["-ALARM_TIME-"])
            alarm_time = values["-ALARM_TIME-"]


    # Schließen Sie das Fenster
    window.close()


# Flask-Routen
@app.route('/presence', methods=['GET'])
def get_sleep_status():
    return jsonify({'status': presence})

@app.route('/alarm', methods=['GET'])
def get_alarm():
    return jsonify({'id':1, 'alarm_time': str(alarm_time), 'status': alarm_active})

@app.route('/alarm/<alarm_id>', methods=['GET'])
def get_alarm_status(alarm_id):
    print(alarm_id)
    return jsonify({'id':alarm_id, 'alarm_time': str(alarm_time), 'status': alarm_active})

if __name__ == '__main__':
    # Starten Sie die Flask-App und Tkinter-GUI in Threads
    from threading import Thread

    api_thread = Thread(target=app.run, kwargs={'port': 5000})
    api_thread.start()

    gui_thread = Thread(target=create_gui)
    gui_thread.start()