package com.example.gameofquestions.LoginPagE;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.gameofquestions.R;



public class MyService extends Service {


    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        player = MediaPlayer.create(this,
                R.raw.gottheme);


        //loops theme tune
        player.setLooping(true);

        //starts theme
        player.start();


        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
     //stops theme
       player.stop();
    }
}