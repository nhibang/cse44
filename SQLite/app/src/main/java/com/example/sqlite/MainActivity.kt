package com.example.sqlite

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.sqlite.data.DatabaseHelper

class MainActivity : ComponentActivity() {
    private lateinit var dbHelper: DatabaseHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)

        val etName = findViewById<EditText>(R.id.edt_name)
        val etPhone = findViewById<EditText>(R.id.edt_phone)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnUpdate = findViewById<Button>(R.id.btn_update)
        val btnDelete = findViewById<Button>(R.id.btn_delete)
        val tvResult = findViewById<TextView>(R.id.txt_info)
        val btnLoad = findViewById<Button>(R.id.btn_load)

        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val phone = etPhone.text.toString()
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                dbHelper.insertContact(name, phone)
                Toast.makeText(this, "Đã thêm!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        btnUpdate.setOnClickListener {
            val name = etName.text.toString()
            val phone = etPhone.text.toString()
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                dbHelper.updateContact(name, phone)
                Toast.makeText(this, "Đã cập nhật!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        btnDelete.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                dbHelper.deleteContact(name)
                Toast.makeText(this, "Đã xóa!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nhập tên cần xóa!", Toast.LENGTH_SHORT).show()
            }
        }

        // Xử lý nút "Hiển thị"
        btnLoad.setOnClickListener {
            val contacts = dbHelper.getAllContacts()
            tvResult.text = contacts.joinToString("\n")
        }

    }
}

