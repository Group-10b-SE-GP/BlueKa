package com.group10b.blueka;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

public class Settingspage extends AppCompatActivity {
    ToggleButton btnToggleDark;
    ToggleButton bluetoothbutton;
    ToggleButton locationbutton;
    BluetoothAdapter myBluetoothAdapter;
    LocationManager locationManager;
    boolean locationStatus;
    //Creating an object of intent
    Intent btEnablingIntent;
    int requestCodeForEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);

        //--------------------------BluetoothButton-----------------
        bluetoothbutton = (ToggleButton) findViewById(R.id.bluetooth_button);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btEnablingIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        requestCodeForEnable = 1;
        setBluetoothButtonStatus();
        bluetoothbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    //The toggle is enabled
                    bluetoothONMethod();

                } else {
                    // The toggle is disabled
                    bluetoothOFFMethod();
                }
            }
        });

        //------------------------LocationButton--------------------
        locationbutton = (ToggleButton) findViewById(R.id.location_button);
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        locationStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        checkLocationButtonState();
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        });

        //----------------Toolbarcode---------------------------------------
        Toolbar toolbars = findViewById(R.id.toolbarsettings);
        setSupportActionBar(toolbars);

        // Set title to false AFTER toolbar has been set
        try
        {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        catch (NullPointerException e){}

        ////////////////////////////////////////For Dark Mode////////////////////////////////////////////
        btnToggleDark
                = findViewById(R.id.btnToggleDark);

        // Saving state of our app
        // using SharedPreferences
        SharedPreferences sharedPreferences
                = getSharedPreferences(
                "sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor
                = sharedPreferences.edit();
        final boolean isDarkModeOn
                = sharedPreferences
                .getBoolean(
                        "isDarkModeOn", false);

        // When user reopens the app
        // after applying dark/light mode
        if (isDarkModeOn) {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_YES);
            btnToggleDark.setChecked(true);
        }
        else {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_NO);
            btnToggleDark.setChecked(false);
        }

        btnToggleDark.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {
                        // When user taps the enable/disable
                        // dark mode button
                        if (isDarkModeOn) {

                            // if dark mode is on it
                            // will turn it off
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_NO);
                            // it will set isDarkModeOn
                            // boolean to false
                            editor.putBoolean(
                                    "isDarkModeOn", false);
                            editor.apply();

                            // change text of Button
                            btnToggleDark.setChecked(false);
                        }
                        else {

                            // if dark mode is off
                            // it will turn it on
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_YES);

                            // it will set isDarkModeOn
                            // boolean to true
                            editor.putBoolean(
                                    "isDarkModeOn", true);
                            editor.apply();

                            // change text of Button
                            btnToggleDark.setChecked(true);

                        }
                    }
                });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu settingsmenu){
        getMenuInflater().inflate(R.menu.settingsmenu,settingsmenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id== R.id.backid){
            openMainpage();
        }
        return true;
    }
    public void openMainpage() {
        Intent intent = new Intent(this, com.group10b.blueka.MainActivity.class);
        startActivity(intent);

    }

    public void setBluetoothButtonStatus(){
        if (myBluetoothAdapter.isEnabled()){
            bluetoothbutton.setChecked(true);
        } else if (!myBluetoothAdapter.isEnabled()){
            bluetoothbutton.setChecked(false);
        }
    }

    /**
     * Method to switch off bluetooth and display a message
     */
    private void bluetoothOFFMethod(){
        bluetoothbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBluetoothAdapter.isEnabled()){
                    myBluetoothAdapter.disable();
                    bluetoothbutton.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Bluetooth is disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Method to switch ON bluetooth
     */
    private void bluetoothONMethod(){
        bluetoothbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBluetoothAdapter == null){
                    Toast.makeText(getApplicationContext(),"Bluetooth is not supported in this device", Toast.LENGTH_SHORT).show();
                }else if (!myBluetoothAdapter.isEnabled()){
                    //startActivityForResult(btEnablingIntent,REQUEST_ENABLE_BT);
                    myBluetoothAdapter.enable();
                    bluetoothbutton.setChecked(true);
                    Toast.makeText(getApplicationContext(),"Bluetooth is enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void checkLocationButtonState(){
        if (locationStatus == true){
            Toast.makeText(getApplicationContext(),"Location is enabled", Toast.LENGTH_SHORT).show();
            locationbutton.setChecked(true);
        } else {
            Toast.makeText(getApplicationContext(),"Location is disabled", Toast.LENGTH_SHORT).show();
            locationbutton.setChecked(false);
        }
    }

}