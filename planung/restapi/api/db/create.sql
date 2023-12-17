DROP TABLE IF EXISTS "Alarm_Day_Relation";
DROP TABLE IF EXISTS "Alarm";
DROP TABLE IF EXISTS "Day";
DROP TABLE IF EXISTS "Area_Log";
DROP TABLE IF EXISTS "Area_Status";
DROP TABLE IF EXISTS "Area";

---------------------------------------------------------------
---------------------------------------------------------------
---------------------------------------------------------------
-- Alarm Config
---------------------------------------------------------------
CREATE TABLE "Day" (
	"ID"	INTEGER NOT NULL,
	"NAME"	TEXT NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

INSERT INTO Day (name) values ('Montag');
INSERT INTO Day (name) values ('Dienstag');
INSERT INTO Day (name) VALUES ('Mittwoch');
INSERT INTO Day (name) VALUES ('Donnerstag');
INSERT INTO Day (name) VALUES ('Freitag');
INSERT INTO Day (name) VALUES ('Samstag');
INSERT INTO Day (name) VALUES ('Sonntag');

CREATE TABLE "Alarm" (
	"ID"	INTEGER NOT NULL,
	"ALARM_DATE"	TEXT NULL,
	"ALARM_TIME"	TEXT NOT NULL,
	"ACTIVE"	INTEGER NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

INSERT INTO Alarm (ALARM_DATE, ALARM_TIME, ACTIVE) VALUES ('2023-12-24', '18:00', 1);
INSERT INTO Alarm (ALARM_DATE, ALARM_TIME, ACTIVE) VALUES ('2023-12-24', '19:00', 0);
INSERT INTO Alarm (ALARM_DATE, ALARM_TIME, ACTIVE) VALUES (NULL, '20:00', 1);
INSERT INTO Alarm (ALARM_DATE, ALARM_TIME, ACTIVE) VALUES (NULL, '21:00', 0);

CREATE TABLE "Alarm_Day_Relation" (
	"ALARM_ID"	INTEGER NOT NULL,
	"DAY_ID"	INTEGER NOT NULL,
	"ACTIVE"	INTEGER NOT NULL,
	PRIMARY KEY("ALARM_ID","DAY_ID"),
	CONSTRAINT "ALARM_DAY_REL_ALARM_FK" FOREIGN KEY("ALARM_ID") REFERENCES Alarm(ID),
	CONSTRAINT "ALARM_DAY_REL_DAY_FK" FOREIGN KEY("DAY_ID") REFERENCES Day(ID)
);

INSERT INTO Alarm_Day_Relation (ALARM_ID, DAY_ID, ACTIVE) VALUES (3, 1, 1);
INSERT INTO Alarm_Day_Relation (ALARM_ID, DAY_ID, ACTIVE) VALUES (3, 2, 1);
INSERT INTO Alarm_Day_Relation (ALARM_ID, DAY_ID, ACTIVE) VALUES (3, 3, 0);
---------------------------------------------------------------
---------------------------------------------------------------
---------------------------------------------------------------
-- Sensor Data
---------------------------------------------------------------

CREATE TABLE "Area" (
	"ID"	INTEGER NOT NULL,
	"NAME"	TEXT NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

INSERT INTO Area (NAME) VALUES ('Bett');

CREATE TABLE "Area_Status" (
	"ID"	INTEGER NOT NULL,
	"NAME"	TEXT NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

INSERT INTO Area_Status (NAME) VALUES ('anwesend');
INSERT INTO Area_Status (NAME) VALUES ('abwesend');

CREATE TABLE "Area_Log" (
	"ID"	INTEGER NOT NULL,
	"AREA_ID"	INTEGER NOT NULL,
	"TIMESTAMP"	INTEGER NOT NULL,
	"STATUS_ID"	INTEGER NOT NULL,
	CONSTRAINT "AREA_LOG_AREA_FK" FOREIGN KEY("AREA_ID") REFERENCES Area(ID),
	CONSTRAINT "AREA_LOG_STATUS_FK" FOREIGN KEY("STATUS_ID") REFERENCES Area_Status(ID),
	PRIMARY KEY("ID" AUTOINCREMENT)
);

INSERT INTO Area_Log (AREA_ID, timestamp, STATUS_ID) VALUES (1, 1702738701, 1);
INSERT INTO Area_Log (AREA_ID, timestamp, STATUS_ID ) VALUES (1, 1702738801, 2);
INSERT INTO Area_Log (AREA_ID, timestamp, STATUS_ID ) VALUES (1, 1702738901, 1);
INSERT INTO Area_Log (AREA_ID, timestamp, STATUS_ID) VALUES (1, 1702739001, 2);
---------------------------------------------------------------
---------------------------------------------------------------
---------------------------------------------------------------
--
---------------------------------------------------------------
