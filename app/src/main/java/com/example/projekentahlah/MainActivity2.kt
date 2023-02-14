package com.example.projekentahlah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var ye:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        ye=findViewById(R.id.ye)
        val message = intent.getStringExtra("01")
        if (message != null){
            ye.text=message
        }
    }
}