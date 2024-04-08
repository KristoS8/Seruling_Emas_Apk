package com.example.serulingemas.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.serulingemas.Adapter.laguAdapter
import com.example.serulingemas.Model.laguModel
import com.example.serulingemas.R
import com.example.serulingemas.databinding.ActivityLandingPageBinding
import java.util.Locale

private lateinit var binding:ActivityLandingPageBinding
private lateinit var adapter: laguAdapter
private lateinit var searchView: ArrayList<laguModel>

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //button ke info aplikasi
        binding.imgBtnInfoAplikasi.setOnClickListener{
            startActivity(Intent(this@LandingPageActivity, infoAplikasiActivity::class.java))
        }
//        init rv linear layout manager (vertical)
        init()

        //fungsi untuk set adapter pada rv (adapter view)
        setAdapterView()

    }

    private fun setAdapterView() {

        val listData: MutableList<laguModel> = mutableListOf()
        // ambil data sebanyak index pada array lagu
        judulLagu().forEachIndexed{ index, nama ->
            listData.add(
                laguModel(
                    judulLagu()[index],
                    deskripsiLagu()[index],
                    isiLagu()[index]
                )
            )
        }
        adapter = laguAdapter(this@LandingPageActivity,listData)
        binding.rvLagu.adapter = adapter

//        search view
        searchView = ArrayList(listData)

        binding.searchSong.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {


                listData.clear()

                val searchText = newText!!.toLowerCase(Locale.getDefault())

                if (searchText.isNotEmpty()) {

                    searchView.forEach {
                        if (it.judul.toLowerCase(Locale.getDefault()).contains(searchText) ||
                            it.deskripsi.toLowerCase(Locale.getDefault()).contains(searchText)
                        ) {
                            listData.add(it)
                        }
                    }

                    adapter.notifyDataSetChanged()

                } else {
                    listData.clear()
                    listData.addAll(searchView)
                    adapter.notifyDataSetChanged()
                }
                return false
            }

        })

    }

    // ambil judul,deskripsi dan isi dari array
    private fun judulLagu(): Array<String> = resources.getStringArray(R.array.judulLagu)
    private fun deskripsiLagu(): Array<String> = resources.getStringArray(R.array.deskripsiLagu)
    private fun isiLagu(): Array<String> = resources.getStringArray(R.array.isiLagu)

    private fun init(){
        binding.rvLagu.layoutManager = LinearLayoutManager(this@LandingPageActivity,LinearLayoutManager.VERTICAL,false)
    }

}