package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();

    // Constructor
    public AdminUser(Integer employeeID, String role) {
        this.employeeID = employeeID;
        this.role = role;
    }

    @Override
    public boolean assignPin(int pin) {
        if (String.valueOf(pin).length() < 6) {
            return false;
        }
        this.pin = pin;
        return true;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (!this.employeeID.equals(confirmedAuthID)) {
            this.authIncident();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return this.securityIncidents;
    }

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \nReported By ID: %s\nNotes: %s \n",
            new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \nID: %s\nNotes: AUTHORIZATION ATTEMPT FAILED FOR THIS USER \n",
            new Date(), this.employeeID
        );
        securityIncidents.add(report);
    }

    // Setters and Getters
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}