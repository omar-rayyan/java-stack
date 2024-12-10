package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
    private ArrayList<String> patientNotes = new ArrayList<>();

    // Constructor
    public Physician(Integer id) {
        this.id = id;
    }

    @Override
    public boolean assignPin(int pin) {
        if (String.valueOf(pin).length() != 4) {
            return false;
        }
        this.pin = pin;
        return true;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        return this.id.equals(confirmedAuthID);
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \nReported By ID: %s\nPatient Name: %s\nNotes: %s \n",
            date, this.id, patientName, notes
        );
        this.patientNotes.add(report);
    }

    // Setters and Getters
    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}
