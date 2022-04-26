package com.example.tbdhspdn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_maint.*
import kotlinx.android.synthetic.main.activity_main.*

class EditMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_maint)

        buttonHome4.setOnClickListener{
            val i : Intent = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        buttonNhom4.setOnClickListener{
            val i : Intent = Intent(this,MainNhom::class.java)
            startActivity(i)
        }
        buttonTBao4.setOnClickListener{
            val i : Intent = Intent(this,MainTBao::class.java)
            startActivity(i)
        }
        themNhom.setOnClickListener{
            val i : Intent = Intent(this,MainNhapTTNhom::class.java)
            startActivity(i)
        }
        themTBao.setOnClickListener {
            val i : Intent = Intent(this,MainNhapTBao::class.java)
            startActivity(i)
        }
    }
}