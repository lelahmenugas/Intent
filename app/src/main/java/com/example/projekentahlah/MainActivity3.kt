package com.example.projekentahlah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity3 : AppCompatActivity() {
    lateinit var edit_hasil:EditText
    lateinit var confirm:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        edit_hasil = findViewById(R.id.edit_hasil)
        confirm = findViewById(R.id.confirm)

        confirm.setOnClickListener({
            var pesan = edit_hasil.text.toString()
            setResult(RESULT_OK, Intent().putExtra("hasil", pesan))
            finish()
        })
    }
}