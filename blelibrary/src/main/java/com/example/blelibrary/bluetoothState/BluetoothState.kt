package com.example.blelibrary.bluetoothState


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat


class BluetoothState(private val context: Context, bluetoothManagerInterface: BluetoothManagerInterface): BluetoothStateInterface {

    private val adapter = bluetoothManagerInterface.getBluetoothManager().adapter


    override fun enableBluetooth() {
        if (adapter != null && adapter.isEnabled) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
            }
            adapter.enable()
        }
    }

    override fun isBluetoothEnabled(): Boolean {
        return adapter != null && adapter.isEnabled
    }

}