package com.example.blelibrary.bluetoothState

import android.bluetooth.BluetoothManager
import android.content.Context

class BluetoothManagerImpl (private val context: Context): BluetoothManagerInterface {
    override fun getBluetoothManager(): BluetoothManager {
        return context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    }
}