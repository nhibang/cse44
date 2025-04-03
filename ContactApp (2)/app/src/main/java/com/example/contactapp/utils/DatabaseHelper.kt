package com.example.contactapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.contactapp.model.Contact

class DatabaseHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, DATABASE_NAME, null, DATABASE_VERSION)

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ContactApp.db"
        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE contact (id INTEGER PRIMARY KEY, name TEXT, phone TEXT)"
        val SQL_DELETE_ENTRIES ="DROP TABLE IF EXISTS contact"
    }

    @SuppressLint("Range")
    fun getAllContacts(): List<Contact>{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM contact", null)
        val contacts = mutableListOf<Contact>()
        with(cursor){
            while (moveToNext()){
                val id = getInt(getColumnIndex("id"))
                val name = getString(getColumnIndex("name"))
                val phone = getString(getColumnIndex("phone"))
                contacts.add(Contact(id, name, phone))
            }
        }
        return contacts
    }
}

