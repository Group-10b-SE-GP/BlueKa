package com.group10b.blueka;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;


public class SoundService extends Service {
    //getting the sound snippet from resources folder
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    private int originalVolume;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    static boolean started;
    static boolean destroyed;

    @Override
    public void onCreate() {
        super.onCreate();
        started = true;
        mediaPlayer = MediaPlayer.create(this, R.raw.merdeka);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        originalVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        //audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
        //mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public int onStartCommand (Intent intent,int flags, int startId){

        /**
         * Condition to verify if the phone is on ringer mode
         * If phone is muted, then the snippet shall not be played
         */
        if (audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL){
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.start();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, originalVolume, 0);
            }
        });

        return START_STICKY;
    }


    @Override
    public void onDestroy(){
        destroyed = true;
        mediaPlayer.stop();
    }
}