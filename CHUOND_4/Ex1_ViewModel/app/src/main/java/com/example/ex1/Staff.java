package com.example.ex1;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.util.Date;

public class Staff {
    private String staffId;
    private String firstName;
    private String lastName;
    private String midName;
    private Date birthDate;
    private long salary;

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(String birthDate) {
        setBirthDate(Utils.stringToDate(birthDate));
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Staff(String id, String fullName, String birthDate, long salary){
        setStaffId(id);
        createFullName(fullName);
        setBirthDate(birthDate);
        setSalary(salary);
    }

    private void createFullName(String fullName){
        String[] names = fullName.split("\\s+");
        String first = "";
        String last = "";
        StringBuilder mid = new StringBuilder();
        if (names.length == 1) {
            first = names[0];
        }
        if (names.length == 2) {
            first = names[1];
            last = names[0];
        }
        if (names.length > 2){
            first = names[names.length - 1];
            last = names[0];
            for (int i = 1; i < names.length - 1; i++) {
                mid.append(names[i]).append(" ");
            }
        }
        setFirstName(first);
        setLastName(last);
        setMidName(mid.toString().trim());
    }

    @SuppressLint("SimpleDateFormat")
    @NonNull
    @Override
    public String toString() {
        return staffId + '-' + lastName + ' ' + midName + ' ' +
                firstName + '-' + Utils.dateToString(birthDate) + '-' + salary;
    }
}
