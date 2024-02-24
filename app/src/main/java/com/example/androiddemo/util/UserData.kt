package com.example.androiddemo.util

import android.content.Context

class UserData(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("Authorization", Context.MODE_PRIVATE)

    fun setAuthorized() {
        sharedPreferences.edit().putBoolean("Authorized", true).apply()
    }

    fun isAuthorized(): Boolean {
        return sharedPreferences.getBoolean("Authorized", false)
    }
}