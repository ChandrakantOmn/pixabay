package com.demo.pagedemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.pagedemo.api.PhotoRetriever
import com.demo.pagedemo.models.APIResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var photos: List<APIResponse.Hit>? = null
    var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val retriever = PhotoRetriever()

        val callback = object : Callback<APIResponse> {
            override fun onFailure(call: Call<APIResponse>?, t: Throwable?) {
                Log.e("MainActivity", "Problems calling API", t)
            }

            override fun onResponse(call: Call<APIResponse>?, response: Response<APIResponse>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photos = response?.body()?.hits as List<APIResponse.Hit>?
                    mainAdapter = MainAdapter(
                        this@MainActivity.photos!!,
                        this@MainActivity
                    )
                    recyclerView.adapter = mainAdapter
                }
            }
        }

        retriever.getPhotos(callback)
    }

    override fun onClick(view: View?) {
        val intent = Intent(this, DetailActivity::class.java)
        val holder = view?.tag as MainAdapter.PhotoHolder
        intent.putExtra(
            DetailActivity.PHOTO,
            mainAdapter?.getPhoto(holder.adapterPosition)
        )
        startActivity(intent)
    }


}
