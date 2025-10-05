package com.example.myapplication.data.model;

import com.example.myapplication.utils.StudentUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Student {
    @JsonProperty("id")
    private String mStudentId;
    private FullName mFullName;
    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = StudentUtils.DATE_FORMAT)
    private Date mBirthDate;
    @JsonProperty("address")
    private String mAddress;
    @JsonProperty("gender")
    private String mGender;
    @JsonProperty("email")
    private String mEmail;
    @JsonProperty("major")
    private String mMajor;
    @JsonProperty("gpa")
    private float mGpa;
    @JsonProperty("year")
    private int mYear;

    public Student() {

    }

    @JsonProperty("full_name")
    private void unpackFullName(Map<String, Object> fullName) {
        this.mFullName = new FullName(
                Objects.requireNonNull(fullName.get("first")).toString(),
                Objects.requireNonNull(fullName.get("last")).toString(),
                Objects.requireNonNull(fullName.get("midd")).toString()
        );
    }

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String studentId) {
        mStudentId = studentId;
    }

    public Date getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(Date birthDate) {
        mBirthDate = birthDate;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getMajor() {
        return mMajor;
    }

    public void setMajor(String major) {
        mMajor = major;
    }

    public float getGpa() {
        return mGpa;
    }

    public void setGpa(float gpa) {
        mGpa = gpa;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(mStudentId, student.mStudentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mStudentId);
    }

    public String getFullName() {
        return mFullName.lastName + " " + mFullName.midName + " " + mFullName.firstName;
    }

    static class FullName {
        private String firstName;
        private String lastName;
        private String midName;

        public FullName() {
        }

        public FullName(String firstName, String lastName, String midName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.midName = midName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }
    }
}
