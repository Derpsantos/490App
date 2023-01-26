package com.example.a490app;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import handlers.FlightHandler;

public class DataHelper {

    private static final String KEY_flight = "flight";

    FirebaseDatabase database;

    public DataHelper(){ this.database = FirebaseDatabase.getInstance();}

    public void add_flight(String id, long timestamp, List<Integer> Motor_temps, List<Integer> Rotor_temps, Boolean Rotor_issue ){
        Flight flight = new Flight(id, timestamp, Motor_temps, Rotor_temps, Rotor_issue);

        database.getReference().child(KEY_flight).child(id).setValue(flight);
    }

    public void getFlight(String id, FlightHandler handle ){
        database.getReference()
                .child(KEY_flight)
                .child(id)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Flight flight = snapshot.getValue(Flight.class);
                        handle.handle(flight);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}
