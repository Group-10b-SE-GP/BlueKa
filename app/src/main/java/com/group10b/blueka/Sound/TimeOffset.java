package com.group10b.blueka.Sound;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.group10b.blueka.MainActivity;

import java.util.concurrent.ExecutionException;

public class TimeOffset {

    final SntpClient sntpClient = new SntpClient();
    //Context context;
    //public TimeOffset(){ }

   /*@SuppressLint("StaticFieldLeak")
    public void getValue()  {
       try {
           new AsyncTask<Void, Integer, Boolean>() {
               @Override
               protected Boolean doInBackground(Void... params) {
                   return sntpClient.requestTime("pool.ntp.org", 3000);
               }
               @Override
               protected void onPostExecute(Boolean result) {
                   if (result) {
                       String offsetString = sntpClient.getOffsetString();
                       System.out.println("Offset String: "+offsetString);
                   }
               }
           }.execute().get();
       } catch (ExecutionException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }*/



    public long getOffsetValue(){
        //getValue();
        //String str = sntpClient.getOffsetString();
        String str = MainActivity.offset;
        Log.d("Phone Offset: ", str);
        int length = str.length();
        String substr = str.substring(1,length);
        return Long.parseLong(substr);
    }

    public Boolean getOffsetSign(){
        //getValue();
        //String str = sntpClient.getOffsetString();
        String str = MainActivity.offset;
        Boolean value;
        char sign = str.charAt(0);
        if (sign == '+'){
            value = true;
        } else {
            value = false;
        }
        return value;
    }


}
