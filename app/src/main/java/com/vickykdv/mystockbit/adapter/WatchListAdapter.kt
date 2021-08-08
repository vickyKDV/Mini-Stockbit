package com.vickykdv.mystockbit.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickykdv.mystockbit.databinding.ItemWatchlistBinding
import com.vickykdv.mystockbit.extension.ExtentionUtils.changeColor
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.utils.UtilsHelper.formatChange
import com.vickykdv.mystockbit.utils.UtilsHelper.formatCurrencyChanges
import com.vickykdv.mystockbit.utils.UtilsHelper.formatPercentage
import com.vickykdv.mystockbit.utils.UtilsHelper.formatPrice

class WatchListAdapter (private val showDetail: (DataItem) -> Unit
) : PagedListAdapter<DataItem, WatchListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemWatchlistBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            with(getItem(position)) {
                this?.coinInfo?.internal.let {
                    txtAcronim.text = it
                }

                this?.coinInfo?.fullName.let {
                    txtName.text = it
                }
                this?.rAW?.let {
                    it.rawIDR.let { idR ->
                        val price = idR.pRICE
                        val changePrice = idR.cHANGEHOUR
                        txtPrice.text = "USD ${formatPrice(price)}"
                        txtCurrencyChange.text = formatCurrencyChanges(this)
                        txtCurrencyChange.changeColor(changePrice,holder.itemView.context)

                    }
                }
            }
            root.setOnClickListener {
                getItem(position)?.let { it1 -> showDetail(it1) }
            }
        }
    }

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<DataItem>(){
            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.coinInfo.id == newItem.coinInfo.id
            }

            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
    class ViewHolder(val binding: ItemWatchlistBinding) : RecyclerView.ViewHolder(binding.root)
}