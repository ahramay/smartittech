package com.asifnazir.urdubiblequiz;

import android.content.Context;

/**
 * Created by Rajesh Dabhi on 28/6/2017.
 */

public class Session_management {
    SharedPreferenceUtil pref;
    Context context;

    int PRIVATE_MODE = 0;

    public Session_management(Context context) {

        this.context = context;
        pref = new SharedPreferenceUtil(context);
    }


    // Get Login State
    public String getRedeem() {
        return pref.getString("redeem", "");
    }

    public void setRedeem(String value) {
        pref.setString("redeem", value);
    }

    public String getSpinDate() {
        return pref.getString("spin", "");
    }

    public void setSpinDate(String value) {
        pref.setString("spin", value);
    }

    public int getIndex() {
        return pref.getInt("index", 0);
    }

    public void setIndex(int value) {
        pref.setInt("index", value);
    }
}
