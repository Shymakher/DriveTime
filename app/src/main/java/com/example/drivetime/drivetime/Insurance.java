package com.example.drivetime.drivetime;

import android.graphics.Bitmap;

/**
 * Created by Vovanchik on 20.02.2015.
 */
public class Insurance {

    private String mObjectId;
    private Bitmap bitmap;
    private String mInsurance;
    private String mPrice;

    public Insurance(String mObjectId, Bitmap bitmap, String mInsurance, String mPrice) {
        this.mObjectId= mObjectId;
        this.bitmap = bitmap;
        this.mInsurance = mInsurance;
        this.mPrice = mPrice;
    }

    public String getmObjectId() {
        return mObjectId;
    }

    public void setmObjectId(String mObjectId) {
        this.mObjectId = mObjectId;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getmInsurance() {

        return mInsurance;
    }

    public void setmInsurance(String mInsurance) {

        this.mInsurance = mInsurance;
    }



    public String getmPrice() {

        return mPrice;
    }

    public void setmPrice(String mPrice) {

        this.mPrice = mPrice;
    }
}
