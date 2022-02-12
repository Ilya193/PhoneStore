package com.xlwe.phonestore.presentation.adapters.bestseller

import androidx.recyclerview.widget.DiffUtil
import com.xlwe.phonestore.domain.model.BestSeller

class BestSellerDiffCallback: DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}