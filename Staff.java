package sample;

import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class Staff {
    private SimpleStringProperty StaffID;
    private SimpleStringProperty Name;
    private SimpleStringProperty Password;
    private SimpleStringProperty Job;
    private SimpleStringProperty Phone;
    private SimpleStringProperty WorkHour;
    private SimpleStringProperty OffWorkHour;

    public String getWorkHour() {
        return WorkHour.get();
    }

    public SimpleStringProperty workHourProperty() {
        return WorkHour;
    }

    public void setWorkHour(String workHour) {
        this.WorkHour =new SimpleStringProperty(workHour);
    }

    public String getOffWorkHour() {
        return OffWorkHour.get();
    }

    public SimpleStringProperty offWorkHourProperty() {
        return OffWorkHour;
    }

    public void setOffWorkHour(String offWorkHour) {
        this.OffWorkHour = new SimpleStringProperty(offWorkHour);
    }

    public Staff(){

    }

    public Staff(String staffid,String name,String password,String job,String phone){
        this.StaffID = new SimpleStringProperty(staffid);
        this.Name    = new SimpleStringProperty(name);
        this.Password= new SimpleStringProperty(password);
        this.Job     = new SimpleStringProperty(job);
        this.Phone   = new SimpleStringProperty(phone);
    }

    public String getStaffID() {
        return StaffID.get();
    }

    public SimpleStringProperty staffIDProperty() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        this.StaffID = new SimpleStringProperty(staffID);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name= new SimpleStringProperty(name);
    }

    public String getPassword() {
        return Password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = new SimpleStringProperty(password);
    }

    public String getJob() {
        return Job.get();
    }

    public SimpleStringProperty jobProperty() {
        return Job;
    }

    public void setJob(String job) {
        this.Job= new SimpleStringProperty(job);
    }

    public String getPhone() {
        return Phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone= new SimpleStringProperty(phone);
    }
}
