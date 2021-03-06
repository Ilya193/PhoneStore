package com.xlwe.phonestore.presentation.adapters.hotsales

import androidx.recyclerview.widget.DiffUtil
import com.xlwe.phonestore.domain.model.HomeStore

class HotSalesDiffCallback: DiffUtil.ItemCallback<HomeStore>() {
    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}