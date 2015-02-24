package com.example.drivetime.drivetime;

/**
 * Created by Vovanchik on 20.02.2015.
 */
public class Insurance {
    private String mInsurance;
    private String mPrice;

    public Insurance(String mInsurance, String mPrice) {
        this.mInsurance = mInsurance;
        this.mPrice = mPrice;
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
