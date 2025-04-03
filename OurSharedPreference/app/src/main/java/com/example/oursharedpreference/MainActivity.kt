package com.example.oursharedpreference

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
import com.example.oursharedpreference.ui.theme.OurSharedPreferenceTheme

class MainActivity : ComponentActivity() {
    //Khai bao thuo tinh cua 1 lop main
    private lateinit var edt_Phone: EditText
    private lateinit var btn_sava: Button
    private lateinit var btn_load: Button
    private lateinit var txt_info: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // tham chieu phan tu view thuc te tren giao dien
        edt_Phone = findViewById(R.id.edt_phone)
        btn_sava = findViewById(R.id.btn_save)
        btn_load = findViewById(R.id.btn_load)
        txt_info = findViewById(R.id.txt_info)

        btn_sava.setOnClickListener {
            // LAY RA TRI NHAP VAO EDITTEXT
            val phone = edt_Phone.text.toString()
            //Luu gia tri nay vao SharedPreference
            val sharedPreferences = getSharedPreferences("NHI", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("Phone", phone)
            // lưu thay đổi apply
            editor.apply()
        }
        btn_load.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Nhi", MODE_PRIVATE)
            val phone = sharedPreferences.getString("phone", "")
            txt_info.setText(phone)

        }

    }
}
