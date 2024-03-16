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
        val binding = ListLaguBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: laguAdapter.ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.judulLagu.text = this.judul
                binding.deskripsiLagu.text = this.deskripsi

                binding.btnKeLagu.setOnClickListener{v: View->
                    val position: Int = adapterPosition
                    val bundle = Bundle()
                    bundle.putString("judulLagu",this.judul)
                    bundle.putString("deskripsiLagu",this.deskripsi)
                    bundle.putString("isiLagu",this.isi)

                    val intent = Intent(context,detailLaguActivity::class.java)
                    intent.putExtras(bundle)
                    context?.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int = list.size


}