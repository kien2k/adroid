package com.example.tbdhspdn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_maint.*
import kotlinx.android.synthetic.main.activity_main_nhap_t_bao.*


class MainNhapTBao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nhap_t_bao)
        buttonHome4_2.setOnClickListener{
            val i : Intent = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        buttonNhom4_2.setOnClickListener{
            val i : Intent = Intent(this,MainNhom::class.java)
            startActivity(i)
        }
        buttonTB4_2.setOnClickListener{
            val i : Intent = Intent(this,MainTBao::class.java)
            startActivity(i)
        }
        buttonEdit4_2.setOnClickListener {
            val i : Intent = Intent(this,EditMain::class.java)
            startActivity(i)
        }
    }
}