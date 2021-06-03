package sample;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resident {
    private String name;
    private String ID;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;
    private Date dob;
    private DateTime admitted;
    private DateTime discharged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public DateTime getAdmitted() {
        return admitted;
    }

    public void setAdmitted(DateTime admitted) {
        this.admitted = admitted;
    }

    public DateTime getDischarged() {
        return discharged;
    }

    public void setDischarged(DateTime discharged) {
        this.discharged = discharged;
    }

    public String setDate(String time, Date date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.toString();
    }

    public String setDate(Date date) {
//        try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
//            date =simpleDateFormat.parse(time);
        String current = simpleDateFormat.format(System.currentTimeMillis());
        return current;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }
}
