package com.example.tbdhspdn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nhap_t_t_nhom.*


class MainNhapTTNhom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nhap_t_t_nhom)
        buttonHome4_1.setOnClickListener{
            val i : Intent = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        buttonNhom4_1.setOnClickListener{
            val i : Intent = Intent(this,MainNhom::class.java)
            startActivity(i)
        }
        buttonTB4_1.setOnClickListener{
            val i : Intent = Intent(this,MainTBao::class.java)
            startActivity(i)
        }
        buttonEdit4_1.setOnClickListener {
            val i : Intent = Intent(this,EditMain::class.java)
            startActivity(i)
        }
    }
}