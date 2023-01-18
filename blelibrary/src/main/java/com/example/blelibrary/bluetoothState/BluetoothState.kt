package com.example.blelibrary.bluetoothState


import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.widget.Toast


class BluetoothState: BluetoothStateInterface {
    override fun showToast(context: Context, message: String) {
        Toast.makeText(context,"Toast shown from Library",Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("MissingPermission")
    override fun enableBluetooth(context: Context) {
        if (BluetoothAdapter.getDefaultAdapter() != null && !BluetoothAdapter.getDefaultAdapter().isEnabled) {
            BluetoothAdapter.getDefaultAdapter().enable()
        }
    }

    override fun isBluetoothEnabled(): Boolean {
        return BluetoothAdapter.getDefaultAdapter() != null && BluetoothAdapter.getDefaultAdapter().isEnabled
    }
}