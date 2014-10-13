package com.example.kaustin.santos;

import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kaustin on 10/1/2014.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView;  //View for the main fragment

        /* SETTING UP BLUETOOTH */
        int REQUEST_ENABLE_BT = 11; //System passes back as request code parameter
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
            Log.i("devlog", "Unable to run bluetooth");

            // Tell user device does not support Bluetooth
            rootView = inflater.inflate(R.layout.fragment_nobluetooth, container, false);

        } else {
            //Ensure Bluetooth in enabled
            if (!mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);

                //If Blue tooth exists & enabled, launch main app
                rootView = inflater.inflate(R.layout.fragment_main, container, false);

            } else {

                // Tell user Bluetooth is not enabled. Must turn on to use
                rootView = inflater.inflate(R.layout.fragment_main, container, false);
            }
        }

        return rootView;
    }
}

