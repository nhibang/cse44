package com.example.csesport1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.csesport1.ui.theme.CSESport1Theme
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //tham chieu cac phan tu tren Activity
        //  val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        // xu li su kien khi chon item tren 
        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_running -> {
                    loadFrgament(RunningFragment())
                    true
                }

                R.id.menu_item_cycling -> {
                    loadFrgament(CyclingFrament())
                    true
                }
            }
            true
        }
    }

    private fun loadFrgament(fragment: Fragment){
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_main, fragment)
                .commit()
        }

    }