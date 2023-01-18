package com.example.blelibrary.bluetoothState

import android.content.Context

interface BluetoothStateInterface {

    fun showToast(context: Context, message:String)

    fun enableBluetooth(context: Context)

    fun isBluetoothEnabled(): Boolean

}