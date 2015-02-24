package com.example.drivetime.drivetime;

import java.util.Vector;

/**
 * Created by Vovanchik on 20.02.2015.
 */
public class Common {
    private static Common instance = null;

    public static Common getInstance() {
        if (instance == null) {
            instance = new Common();
            user = new Vector<User>();
            insurance = new Vector<Insurance>();
        }
        return instance;
    }

    private Common() {
    }

    private static Vector<User> user;

    public Vector<User> getUser(){
        return user;
    }

    private static Vector<Insurance> insurance;

    public Vector<Insurance> getInsurance(){
        return insurance;
    }


}
