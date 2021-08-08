package com.vickykdv.mystockbit.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickykdv.mystockbit.databinding.ItemWatchlistBinding
import com.vickykdv.mystockbit.databinding.ItemWatchlistLoadBinding
import com.vickykdv.mystockbit.extension.ExtentionUtils.changeColor
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.utils.UtilsHelper.formatChange
import com.vickykdv.mystockbit.utils.UtilsHelper.formatCurrencyChanges
import com.vickykdv.mystockbit.utils.UtilsHelper.formatPercentage
import com.vickykdv.mystockbit.utils.UtilsHelper.formatPrice
import java.util.ArrayList

class LoadWatchListAdapter (private var listData: List<Int> = ArrayList()) :
    RecyclerView.Adapter<LoadWatchListAdapter.ProductsVH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsVH {
        return ProductsVH(ItemWatchlistLoadBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ProductsVH, position: Int) {
        with(holder) {
            with(listData[position]) {

            }
        }
    }


    fun updateData(data: List<Int>) {
        this.listData = data
        notifyDataSetChanged()
    }

    inner class ProductsVH(val binding: ItemWatchlistLoadBinding) :
        RecyclerView.ViewHolder(binding.root)
}