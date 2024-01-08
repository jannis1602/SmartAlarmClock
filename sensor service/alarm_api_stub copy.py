from flask import Flask, jsonify
from tkinter import Tk, Button, Label, Entry
import datetime

app = Flask(__name__)
status = "not_active"
alarm_time = None

# Tkinter-GUI
def toggle_status():
    global status
    if status == "not_active":
        status = "active"
    else:
        status = "not_active"
    update_gui()

def set_alarm():
    global alarm_time
    alarm_time = entry_alarm.get()
    update_gui()

def update_gui():
    label_status.config(text=f"Status: {status}")
    label_alarm.config(text=f"Alarm Time: {str(alarm_time)}")

def create_gui():
    root = Tk()
    root.title("Status and Alarm Changer")

    label_status = Label(root, text=f"Status: {status}")
    label_status.pack(pady=10)

    active_button = Button(root, text="Toggle Status", command=toggle_status)
    active_button.pack(pady=10)

    label_alarm = Label(root, text=f"Alarm Time: {str(alarm_time)}")
    label_alarm.pack(pady=10)

    entry_alarm = Entry(root, width=20)
    entry_alarm.insert(0, "HH:MM")
    entry_alarm.pack(pady=10)

    alarm_button = Button(root, text="Set Alarm", command=set_alarm)
    alarm_button.pack(pady=10)

    root.mainloop()

# Flask-Routen
@app.route('/sleep', methods=['GET'])
def get_sleep_status():
    return jsonify({'status': status})

@app.route('/alarm', methods=['GET'])
def get_alarm_status():
    return jsonify({'alarm_time': str(alarm_time), 'status': status})

if __name__ == '__main__':
    # Starten Sie die Flask-App und Tkinter-GUI in Threads
    from threading import Thread

    api_thread = Thread(target=app.run, kwargs={'port': 5000})
    api_thread.start()

    gui_thread = Thread(target=create_gui)
    gui_thread.start()
    