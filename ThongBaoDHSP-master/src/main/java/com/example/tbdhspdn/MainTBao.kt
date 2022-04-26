package com.example.tbdhspdn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.buttonTBao1
import kotlinx.android.synthetic.main.activity_main_t_bao.*

class MainTBao : AppCompatActivity() , OnItemClickedTBao {

    private lateinit var mAdapter : TBaoListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_t_bao)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        LoadTBao()
        mAdapter = TBaoListAdapter(this)
        recyclerView.adapter = mAdapter

        buttonHome2.setOnClickListener{
            val i : Intent = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        buttonNhom2.setOnClickListener {
            val i : Intent = Intent(this,MainNhom::class.java)
            startActivity(i)
        }
        buttonT2.setOnClickListener {
            val i : Intent = Intent(this,EditMain::class.java)
            startActivity(i)
        }
    }

    fun LoadTBao()
    {
        val url = "https://my-json-server.typicode.com/khanhhuynh-sun/tbdhsp-json-file/tb.json"
        val jsonObjectRequest1 = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener{
                val tBaoJsonArray = it.getJSONArray("articles")
                val tBaoArray = ArrayList<ThongBao>()
                for(i in 0 until tBaoJsonArray.length())
                {
                    val tBaoJsonObject = tBaoJsonArray.getJSONObject(i)
                    val thongBao = ThongBao(
                        tBaoJsonObject.getString("author"),
                        tBaoJsonObject.getString("title"),
                        tBaoJsonObject.getString("url"),
                        tBaoJsonObject.getString("urlToImage")
                    )
                    tBaoArray.add(thongBao)
                }
                mAdapter.updateTBao(tBaoArray)
            },
            Response.ErrorListener {
            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest1)
    }
    override fun ItemClicked(items: ThongBao) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(items.url))
    }
}