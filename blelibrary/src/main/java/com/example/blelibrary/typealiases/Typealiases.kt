package com.example.blelibrary.permissions


internal typealias PermissionRequestCallback = (granted: Boolean) -> Unit

internal typealias Callback <T> = (T) -> Unit

internal typealias EmptyCallback = () -> Unit