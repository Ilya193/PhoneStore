package com.xlwe.phonestore.presentation.adapter.bestseller

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xlwe.phonestore.R
import com.xlwe.phonestore.databinding.BestSellerItemBinding
import com.xlwe.phonestore.domain.model.BestSeller

class BestSellerAdapter: ListAdapter<BestSeller, BestSellerAdapter.ViewHolder>(BestSellerDiffCallback()) {
    class ViewHolder(val binding: BestSellerItemBinding): RecyclerView.ViewHolder(binding.root)

    //var onItemClickListener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BestSellerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phone = getItem(position)
        with(holder) {
            if (phone.is_favorites) {
                binding.imgHeart.setBackgroundResource(R.drawable.ic_heart_yes_back)
            }

            binding.price.text = "$"+phone.discount_price.toString()
            binding.discountPrice.text = "$"+phone.price_without_discount.toString()
            binding.discountPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.namePhoneTv.text = phone.title
            binding.imgPhone.loadImage(phone.picture)
        }
    }

    private fun ImageView.loadImage(image: String) {
        Glide.with(this)
            .load(image)
            .centerCrop()
            .into(this)
    }
}