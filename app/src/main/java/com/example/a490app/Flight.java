package com.example.a490app;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String id;
    private long timestamp;
    private List<Integer> Motor_temperature;
    private List<Integer> Rotor_temperature;
    private Boolean Rotor_issue;

    public Flight(String id, long timestamp, List<Integer> motor_temp, List<Integer> Rotor_temp, Boolean Rotor_issue){
        this.id=id;
        this.timestamp=timestamp;
        this.Motor_temperature = motor_temp == null ? new ArrayList<>() : motor_temp;
        this.Rotor_temperature = Rotor_temp == null ? new ArrayList<>() : Rotor_temp;
        this.Rotor_issue = Rotor_issue;
    }

    public String getID(){return id;}

    public long getTimestamp(){return timestamp;}

    public List<Integer> getMotor_temperature(){return Motor_temperature;}

    public List<Integer> getRotor_temperature(){return Rotor_temperature;}

    public Boolean getRotor_issue(){return Rotor_issue;}

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDateTime getDateTime() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }




}
