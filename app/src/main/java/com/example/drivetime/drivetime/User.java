package com.example.drivetime.drivetime;

/**
 * Created by Vovanchik on 20.02.2015.
 */
public class User {

    private String mId;

    private int mYear;
    private int mMonth;
    private int mDay;

    private int mMinute;
    private int mHour;

    private int mAge;
    private String mNewDriver;
    private String mCar;
    private String mIfPrivate;
    private String mInsBefore;
    private String mClaims;
    private String mPolice;
    private String mState;
    private String mCity;

    public User(String mId, int mDay, int mMonth, int mYear,
                int mMinute, int mHour,
                int mAge, String mNewDriver, String mCar,
                String mIfPrivate, String mInsBefore, String mClaims,
                String mPolice, String mState, String mCity) {
        this.mId = mId;
        this.mYear = mYear;
        this.mMonth = mMonth;
        this.mDay = mDay;
        this.mMinute = mMinute;
        this.mHour = mHour;
        this.mAge = mAge;
        this.mNewDriver = mNewDriver;
        this.mCar = mCar;
        this.mIfPrivate = mIfPrivate;
        this.mInsBefore = mInsBefore;
        this.mClaims = mClaims;
        this.mPolice = mPolice;
        this.mState = mState;
        this.mCity = mCity;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public int getmMonth() {
        return mMonth;
    }

    public void setmMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public int getmHour() {
        return mHour;
    }

    public void setmHour(int mHour) {
        this.mHour = mHour;
    }

    public int getmMinute() {
        return mMinute;
    }

    public void setmMinute(int mMinute) {
        this.mMinute = mMinute;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmNewDriver() {
        return mNewDriver;
    }

    public void setmNewDriver(String mNewDriver) {
        this.mNewDriver = mNewDriver;
    }

    public String getmCar() {
        return mCar;
    }

    public void setmCar(String mCar) {
        this.mCar = mCar;
    }

    public String getmIfPrivate() {
        return mIfPrivate;
    }

    public void setmIfPrivate(String mIfPrivate) {
        this.mIfPrivate = mIfPrivate;
    }

    public String getmInsBefore() {
        return mInsBefore;
    }

    public void setmInsBefore(String mInsBefore) {
        this.mInsBefore = mInsBefore;
    }

    public String getmClaims() {
        return mClaims;
    }

    public void setmClaims(String mClaims) {
        this.mClaims = mClaims;
    }

    public String getmPolice() {
        return mPolice;
    }

    public void setmPolice(String mPolice) {
        this.mPolice = mPolice;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }
}
