package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ListBarangBinding
import com.example.mvvm.model.Data_Value


class MainAdapter(val data:List<Data_Value>):RecyclerView.Adapter<MainAdapter.ViewHolderUser>() {

    lateinit var onClickUser:OnClickUser

    interface OnClickUser {
        fun clickUser(data:Data_Value)
    }

    fun clickListUser(onClickBarang: OnClickUser){
        this.onClickUser = onClickBarang
    }

    inner class ViewHolderUser(val binding: ListBarangBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(dataList: Data_Value) {
            binding.tvNamauser.text = dataList.first_name
            binding.tvEmail.text = dataList.email
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        return ViewHolderUser(ListBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        val dataList = data[position]
        holder.bind(dataList)
        holder.itemView.setOnClickListener {
           onClickUser.clickUser(dataList)
        }
    }

    override fun getItemCount() = data.size


}