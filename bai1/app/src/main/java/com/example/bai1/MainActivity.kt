package com.example.bai1

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai1.ui.theme.Bai1Theme
import com.example.sharedpreference.PreferenceHelper

class MainActivity : ComponentActivity() {
    //Khai bao thuoc tinh cua 1 lop main
    private lateinit var name: EditText
    private lateinit var pass: EditText
    private lateinit var save: Button
    private lateinit var delete: Button
    private lateinit var show: Button
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var preferenceHelper = PreferenceHelper(this)
        // tham chieu phan tu view thuc te tren giao dien
        name = findViewById(R.id.edt_name)
        pass = findViewById(R.id.edt_pass)
        save = findViewById(R.id.btn_save)
        delete = findViewById(R.id.btn_delete)
        show = findViewById(R.id.btn_show)


        save.setOnClickListener {
            // LAY RA TRI NHAP VAO EDITTEXT
            val name = name.text.toString()
            val pass = pass.text.toString()
            preferenceHelper.saveData(name, pass)
            }
        delete.setOnClickListener {
            name.setText("")
            pass.setText("")
        }
        show.setOnClickListener {
            val(name, pass) = preferenceHelper.getData()


            // (Optional) Hiển thị thông báo
            Toast.makeText(this@MainActivity, "Nhi", Toast.LENGTH_SHORT).show()
        }



    }
}

