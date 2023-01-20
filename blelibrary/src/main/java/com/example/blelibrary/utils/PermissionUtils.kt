package com.example.blelibrary.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

internal object PermissionUtils {

    @RequiresApi(Build.VERSION_CODES.S)
    private val android12Permissions = arrayOf(Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN)

    private val legacyPermissions = arrayOf(Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN)
    private val locationPermissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

    val permissions by lazy {
        val list = arrayListOf<String>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            list.addAll(android12Permissions)
        } else {
            list.addAll(legacyPermissions)
            list.addAll(locationPermissions)
        }

        list.toTypedArray()
    }

//    fun isBluetoothLowEnergyPresentOnDevice(packageManager: PackageManager): Boolean {
//        return packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)
//    }
//
//    fun isBluetoothPresentOnDevice(packageManager: PackageManager): Boolean {
//        return packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)
//    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M)
    private fun isPermissionRequestRequired() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    private fun isPermissionGranted(context: Context, permission: String): Boolean {
        if (!isPermissionRequestRequired()) return true

        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

    fun isEveryBluetoothPermissionsGranted(context: Context) = permissions.all { isPermissionGranted(context, it) }

    fun isPermissionRationaleNeeded(context: Activity): Boolean {
        if (!isPermissionRequestRequired()) return false

        return permissions.any { context.shouldShowRequestPermissionRationale(it) }
    }

}