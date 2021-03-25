package com.group10b.blueka.Sound;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.group10b.blueka.MainActivity;

import java.util.concurrent.ExecutionException;

/**
 * Implement methods to obtain the offset value
 * as well as the sign of the offset, that is,
 * whether the offset is positive or negative
 */
public class TimeOffset {

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
