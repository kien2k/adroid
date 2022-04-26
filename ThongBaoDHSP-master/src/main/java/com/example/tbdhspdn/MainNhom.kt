package com.example.tbdhspdn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nhom.*

class MainNhom : AppCompatActivity() ,OnItemClickedNhom{

    private lateinit var mAdaptor: NhomListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nhom)

        val recyclerView3: RecyclerView = findViewById(R.id.recyclerView3)
        recyclerView3.layoutManager = LinearLayoutManager(this)

        LoadNhom()
        mAdaptor = NhomListAdapter(this)
        recyclerView3.adapter = mAdaptor
        buttonHome3.setOnClickListener{
            val i : Intent = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        buttonTBao3.setOnClickListener{
            val i : Intent = Intent(this,MainTBao::class.java)
            startActivity(i)
        }
        buttonT3.setOnClickListener {
            val i : Intent = Intent(this,EditMain::class.java)
            startActivity(i)
        }
    }
    fun LoadNhom(){
        val url = "https://my-json-server.typicode.com/khanhhuynh-sun/nhom/group.json"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener {
                val nhomJsonArray = it.getJSONArray("articles")
                val nhomArray = ArrayList<Nhom>()
                for(i in 0 until nhomJsonArray.length()){
                    val newsJsonObject = nhomJsonArray.getJSONObject(i)
                    val nhom = Nhom(
                        newsJsonObject.getString("tennhom"),
                        newsJsonObject.getString("chutich")
                    )
                    nhomArray.add(nhom)
                }
                mAdaptor.updateNhom(nhomArray)
            },
            Response.ErrorListener {

            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
    override fun ItemClick(items: Nhom) {
        TODO("Not yet implemented")
    }
}