package com.asifnazir.urdubiblequiz;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;


public class Constant {








    private static Vibrator sVibrator;
    public static final long VIBRATION_DURATION = 100;
    public static final String PLAYSTORE_URL = "http://play.google.com/store/apps/details?id=";
    public static final boolean DEFAULT_SOUND_SETTING = true;
    public static final boolean DEFAULT_VIBRATION_SETTING = true;
    public static final boolean DEFAULT_MUSIC_SETTING = false;
    public static final boolean DEFAULT_LAN_SETTING = true;


    public static void backSoundonclick(Context mContext) {
        try {
            int resourceId = R.raw.click;
            MediaPlayer mediaplayer = MediaPlayer.create(mContext, resourceId);
            mediaplayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setrightAnssound(Context mContext) {
        try {
            int resourceId = R.raw.right;
            MediaPlayer mediaplayer = MediaPlayer.create(mContext, resourceId);
            mediaplayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setwronAnssound(Context mContext) {
        try {
            int resourceId = R.raw.wrong;
            MediaPlayer mediaplayer = MediaPlayer.create(mContext, resourceId);
            mediaplayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void vibrate(Context context, long duration) {
        if (sVibrator == null) {
            sVibrator = (Vibrator) context
                    .getSystemService(Context.VIBRATOR_SERVICE);
        }
        if (sVibrator != null) {
            if (duration == 0) {
                duration = 50;
            }
            sVibrator.vibrate(duration);
        }
    }
}
