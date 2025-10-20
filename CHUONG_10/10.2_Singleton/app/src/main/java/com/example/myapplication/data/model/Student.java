package com.example.myapplication.data.model;

import androidx.annotation.NonNull;

import com.example.myapplication.utils.AppUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Student {
    @JsonProperty("id")
    private String mId;

    @JsonProperty("full_name")
    private FullName mFullName;

    @JsonProperty("gender")
    private String mGender;

    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppUtils.DATE_FORMAT)
    private Date mBirthDate;

    @JsonProperty("email")
    private String mEmail;

    @JsonProperty("address")
    private String mAddress;

    @JsonProperty("major")
    private String mMajor;

    @JsonProperty("gpa")
    private float mGpa;

    @JsonProperty("year")
    private int mYear;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public FullName getmFullName() {
        return mFullName;
    }

    public void setmFullName(FullName mFullName) {
        this.mFullName = mFullName;
    }

    public Date getmBirthDate() {
        return mBirthDate;
    }

    public void setmBirthDate(Date mBirthDate) {
        this.mBirthDate = mBirthDate;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmMajor() {
        return mMajor;
    }

    public void setmMajor(String mMajor) {
        this.mMajor = mMajor;
    }

    public float getmGpa() {
        return mGpa;
    }

    public void setmGpa(float mGpa) {
        this.mGpa = mGpa;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public static class FullName {
        @JsonProperty("first")
        private String first;

        @JsonProperty("last")
        private String last;

        @JsonProperty("mid")
        private String mid;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        @NonNull
        @Override
        public String toString(){
            return last + " " + mid + " " + first;
        }
    }
}
