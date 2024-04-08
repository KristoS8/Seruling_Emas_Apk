package com.example.serulingemas.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.serulingemas.Activity.detailLaguActivity
import com.example.serulingemas.Model.laguModel
import com.example.serulingemas.databinding.ListLaguBinding

class laguAdapter(private val context: Context?, private val list: List<laguModel>):RecyclerView.Adapter<laguAdapter.ViewHolder>() {
    class ViewHolder(val binding:ListLaguBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // init binding untuk layout list_lagu
        val binding = ListLaguBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: laguAdapter.ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                // set text judul,deskripsi pada list_lagu layout
                binding.judulLagu.text = this.judul
                binding.deskripsiLagu.text = this.deskripsi

                // set button menuju halaman isi lagu
                binding.btnKeLagu.setOnClickListener{v: View->
                    val position: Int = adapterPosition
                    // passing data judul lagu,deskripsi dan isi menuju activity menggunakan bundle
                    val bundle = Bundle()
                    bundle.putString("judulLagu",this.judul)
                    bundle.putString("deskripsiLagu",this.deskripsi)
                    bundle.putString("isiLagu",this.isi)

                    // intent dan passing data
                    val intent = Intent(context,detailLaguActivity::class.java)
                    intent.putExtras(bundle)
                    context?.startActivity(intent)
                }
            }
        }
    }

    // ambil item/lagu sebanyak ukuran list
    override fun getItemCount(): Int = list.size


}