package org.openapitools.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TemporalHelper {
    public Date getAlarmDateAsDate(String alarmDate){
        if(alarmDate == null)
            return null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(alarmDate);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public LocalTime getAlarmTimeAsTime(String alarmTime){
        // Define a formatter based on the time format in your string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse the string to a LocalTime object using the formatter
        LocalTime time = LocalTime.parse(alarmTime, formatter);
        return time;
    }
}
