package com.xlwe.phonestore.presentation.adapters.hotsales

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xlwe.phonestore.databinding.HotSaleItemBinding
import com.xlwe.phonestore.domain.model.HomeStore

class HotSalesAdapter : ListAdapter<HomeStore, HotSalesAdapter.ViewHolder>(HotSalesDiffCallback()) {
    class ViewHolder(val binding: HotSaleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HotSaleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phone = getItem(position)
        with(holder) {
            if (phone.is_new)
                binding.isNew.visibility = View.VISIBLE
            binding.imgPhone.loadImage(phone.picture)
            binding.namePhoneTv.text = phone.title
            binding.descriptionPhoneTv.text = phone.subtitle
        }
    }

    private fun ImageView.loadImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(this)
    }
}