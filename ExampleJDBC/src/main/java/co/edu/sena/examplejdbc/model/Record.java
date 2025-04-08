 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *Fecha: 20/03/2025
 * @author Lina Vanessa Salcedo
 * Objetivo: representa la tabla record
 */
public class Record {
    private int id;
    private String dateRecord;
    private String startTime;
    private String endTime;
    private Employee employee;
    private Key key;
    private String status;

    public Record() {
    }

    public Record(int id, String dateRecord, String startTime, String endTime, Employee employee, Key key, String status) {
        this.id = id;
        this.dateRecord = dateRecord;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
        this.key = key;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(String dateRecord) {
        this.dateRecord = dateRecord;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
