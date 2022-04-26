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

class MainActivity : AppCompatActivity(), OnItemClicked {

    private lateinit var mAdaptor: TinTucListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        LoadTinTuc()
        mAdaptor = TinTucListAdapter(this)
        recyclerView.adapter = mAdaptor

        buttonTBao1.setOnClickListener{
            val i : Intent = Intent(this,MainTBao::class.java)
            startActivity(i)
        }
        buttonNhom1.setOnClickListener {
            val i : Intent = Intent(this,MainNhom::class.java)
            startActivity(i)
        }
        buttonT1.setOnClickListener {
            val i : Intent = Intent(this,EditMain::class.java)
            startActivity(i)
        }
    }

    fun LoadTinTuc(){
        val url = "https://my-json-server.typicode.com/khanhhuynh-sun/ttdhsp-json-file/tt.json"
        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,url,null,
                Response.Listener {
                    val tintucJsonArray = it.getJSONArray("articles")
                    val tintucArray = ArrayList<TinTuc>()
                    for(i in 0 until tintucJsonArray.length()){
                        val newsJsonObject = tintucJsonArray.getJSONObject(i)
                        val thongbao = TinTuc(
                                newsJsonObject.getString("author"),
                                newsJsonObject.getString("title"),
                                newsJsonObject.getString("url"),
                                newsJsonObject.getString("urlToImage")
                        )
                        tintucArray.add(thongbao)
                    }
                    mAdaptor.updateTinTuc(tintucArray)
                },
                Response.ErrorListener {

                }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun ItemClick(items: TinTuc) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(items.url))
    }
}