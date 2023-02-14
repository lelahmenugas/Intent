package com.example.projekentahlah

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var intentBiasa:Button
    lateinit var intentData:Button
    lateinit var intentTelpon:Button
    lateinit var intentHasil:Button

    lateinit var hasil: TextView
    lateinit var intentku:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentBiasa=findViewById(R.id.Intent_biasa)
        intentData=findViewById(R.id.Intent_data)
        intentTelpon=findViewById(R.id.Intent_telpon)
        intentHasil=findViewById(R.id.Intent_hasil)

        hasil = findViewById(R.id.hasil)
        intentku=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_OK){
                val dt = result.data!!.getStringExtra("hasil")
                hasil.text = dt
            }

        }

        intentBiasa.setOnClickListener({
            val moveIntent = Intent(this, MainActivity2::class.java)
            startActivity(moveIntent)
        })

        intentData.setOnClickListener({
            val moveIntent = Intent(this, MainActivity2::class.java)
            moveIntent.putExtra("01","String")
            startActivity(moveIntent)
        })
        intentTelpon.setOnClickListener({
            val moveIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"0987654321"))
            startActivity(moveIntent)
        })
        intentHasil.setOnClickListener({
            intentku.launch(Intent(this, MainActivity3::class.java))
        })
    }
}