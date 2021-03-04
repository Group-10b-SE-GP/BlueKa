package com.group10b.blueka.Operation;


import android.bluetooth.BluetoothGatt;
import android.util.Log;

import com.group10b.blueka.Constants;


public class GattCloseOperation extends Operation {
    public GattCloseOperation(BluetoothGatt gatt){
        super(gatt);

    }
    @Override
    public void performOperation() {
        gatt.close();
        Log.i(Constants.TAG,"Gatt closed by queue");
    }
}
