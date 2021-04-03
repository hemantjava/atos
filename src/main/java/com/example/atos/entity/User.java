package com.example.atos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Status")
    private String status;
    private String role;
    private String docStatus;
    private String assignedXML;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getAssignedXML() {
        return assignedXML;
    }

    public void setAssignedXML(String assignedXML) {
        this.assignedXML = assignedXML;
    }
    public User(){}
    public User(String name, String status, String role, String docStatus, String assignedXML) {
        this.name = name;
        this.status = status;
        this.role = role;
        this.docStatus = docStatus;
        this.assignedXML = assignedXML;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", docStatus='" + docStatus + '\'' +
                ", assignedXML='" + assignedXML + '\'' +
                '}';
    }
}
