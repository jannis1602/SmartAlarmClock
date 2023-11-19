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

CREATE TABLE "Alarm" (
	"ID"	INTEGER NOT NULL,
	"TIMESTAMP"	INTEGER NOT NULL,
	"MAX_DURATION"	INTEGER NOT NULL,
	"ACTIVE"	INTEGER NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

CREATE TABLE "Alarm_Day_Relation" (
	"ALARM_ID"	INTEGER NOT NULL,
	"DAY_ID"	INTEGER NOT NULL,
	"ACTIVE"	INTEGER NOT NULL,
	PRIMARY KEY("ALARM_ID","DAY_ID"),
	CONSTRAINT "ALARM_DAY_REL_ALARM_FK" FOREIGN KEY("ALARM_ID") REFERENCES Alarm(ID),
	CONSTRAINT "ALARM_DAY_REL_DAY_FK" FOREIGN KEY("DAY_ID") REFERENCES Day(ID)
);

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

CREATE TABLE "Area_Status" (
	"ID"	INTEGER NOT NULL,
	"NAME"	TEXT NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

CREATE TABLE "Area_Log" (
	"ID"	INTEGER NOT NULL,
	"AREA_ID"	INTEGER NOT NULL,
	"TIMESTAMP"	INTEGER NOT NULL,
	"STATUS_ID"	INTEGER NOT NULL,
	CONSTRAINT "AREA_LOG_AREA_FK" FOREIGN KEY("AREA_ID") REFERENCES Area(ID),
	CONSTRAINT "AREA_LOG_STATUS_FK" FOREIGN KEY("STATUS_ID") REFERENCES Area_Status(ID),
	PRIMARY KEY("ID" AUTOINCREMENT)
);

---------------------------------------------------------------
---------------------------------------------------------------
---------------------------------------------------------------
--
---------------------------------------------------------------