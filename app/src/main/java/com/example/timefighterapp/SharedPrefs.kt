package com.example.timefighterapp

import android.content.Context

fun saveScore(context: Context, type: Int, score: Int) {
    val key = "recordScore$type" // Dynamically create the key
    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    sharedPreferences.edit().putInt(key, score).apply()
}

fun getScore(context: Context, type: Int): Int {
    val key = "recordScore$type"
    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getInt(key, 0) // Default to 0 if no value exists
}