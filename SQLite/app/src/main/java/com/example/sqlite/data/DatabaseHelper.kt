package com.example.sqlite.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "contacts.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "contacts"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_PHONE = "phone"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_PHONE TEXT
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Thêm dữ liệu
    fun insertContact(name: String, phone: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_PHONE, phone)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    // Cập nhật dữ liệu
    fun updateContact(name: String, phone: String): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_PHONE, phone)
        }
        return db.update(TABLE_NAME, values, "$COLUMN_NAME=?", arrayOf(name))
    }

    // Xóa dữ liệu
    fun deleteContact(name: String): Int {
        val db = writableDatabase
        return db.delete(TABLE_NAME, "$COLUMN_NAME=?", arrayOf(name))
    }

    // Lấy tất cả dữ liệu
    fun getAllContacts(): List<String> {
        val db = readableDatabase
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        val contacts = mutableListOf<String>()

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
            val phone = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE))
            contacts.add("Tên: $name - SDT: $phone")
        }
        cursor.close()
        return contacts
    }
}
