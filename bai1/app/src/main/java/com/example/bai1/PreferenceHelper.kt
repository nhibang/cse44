package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

    fun saveData(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("name", username)
        editor.putString("password", password)
        editor.apply()
    }

    fun getData(): Pair<String?, String?> {
        val name = sharedPreferences.getString("name", "")
        val password = sharedPreferences.getString("password", "")
        return Pair(name, password)
    }

    fun clearData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}