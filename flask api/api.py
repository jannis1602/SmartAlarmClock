from flask import Flask, jsonify, request
import sqlite3

app = Flask(__name__)

# Verbindung zur SQLite-Datenbank herstellen (oder erstellen, wenn sie nicht existiert)
conn = sqlite3.connect('database.db')
cursor = conn.cursor()

# Tabelle erstellen, wenn sie nicht existiert
cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        age INTEGER NOT NULL
    )
''')
conn.commit()

# API-Endpunkt, um alle Benutzer abzurufen
@app.route('/api/users', methods=['GET'])
def get_users():
    cursor.execute('SELECT * FROM users')
    users = cursor.fetchall()
    user_list = [{'id': user[0], 'name': user[1], 'age': user[2]} for user in users]
    return jsonify({'users': user_list})

# API-Endpunkt, um einen Benutzer abzurufen
@app.route('/api/users/<int:user_id>', methods=['GET'])
def get_user(user_id):
    cursor.execute('SELECT * FROM users WHERE id = ?', (user_id,))
    user = cursor.fetchone()
    if user:
        user_dict = {'id': user[0], 'name': user[1], 'age': user[2]}
        return jsonify({'user': user_dict})
    else:
        return jsonify({'message': 'Benutzer nicht gefunden'}), 404

# API-Endpunkt, um einen neuen Benutzer hinzuzufügen
@app.route('/api/users', methods=['POST'])
def add_user():
    data = request.get_json()
    name = data.get('name')
    age = data.get('age')

    if name and age:
        cursor.execute('INSERT INTO users (name, age) VALUES (?, ?)', (name, age))
        conn.commit()
        return jsonify({'message': 'Benutzer hinzugefügt'}), 201
    else:
        return jsonify({'message': 'Ungültige Daten'}), 400

# Server starten
if __name__ == '__main__':
    app.run(debug=True)
