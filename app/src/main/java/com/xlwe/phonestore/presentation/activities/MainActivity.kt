package com.xlwe.phonestore.presentation.activities

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.xlwe.phonestore.R
import com.xlwe.phonestore.databinding.ActivityMainBinding
import com.xlwe.phonestore.presentation.adapter.bestseller.BestSellerAdapter
import com.xlwe.phonestore.presentation.adapter.hotsales.HotSalesAdapter
import com.xlwe.phonestore.presentation.fragments.BottomSheetFragment
import com.xlwe.phonestore.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var hotSalesAdapter: HotSalesAdapter
    private lateinit var bestSellerAdapter: BestSellerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK) ==
            Configuration.UI_MODE_NIGHT_YES) {
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        viewModel.getHotSalesList()
        viewModel.getBestSellerList()

        setClickListeners()
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        hotSalesAdapter = HotSalesAdapter()
        binding.recyclerHotSales.adapter = hotSalesAdapter

        bestSellerAdapter = BestSellerAdapter()
        binding.recyclerBestSeller.adapter = bestSellerAdapter

        //val layoutManager = GridLayoutManager(this, 2)
        //binding.recyclerBestSeller.layoutManager = layoutManager
    }

    private fun observeViewModel() {
        viewModel.hotSales.observe(this) {
            hotSalesAdapter.submitList(it)
        }

        viewModel.bestSeller.observe(this) {
            bestSellerAdapter.submitList(it)
        }
    }

    private fun setClickListeners() {
        val bottomSheetFragment = BottomSheetFragment()

        binding.filters.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "BottomSheet")
        }

        binding.cardView1.setOnClickListener {
            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.orange))
            binding.tvCard1.setTextColor(ContextCompat.getColor(applicationContext, R.color.orange))

            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard2.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView3.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard3.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView4.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard4.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }

        binding.cardView2.setOnClickListener {
            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.orange))
            binding.tvCard2.setTextColor(ContextCompat.getColor(applicationContext, R.color.orange))

            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard1.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView3.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard3.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView4.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard4.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }

        binding.cardView3.setOnClickListener {
            binding.cardView3.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.orange))
            binding.tvCard3.setTextColor(ContextCompat.getColor(applicationContext, R.color.orange))

            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard1.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard2.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView4.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard4.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }

        binding.cardView4.setOnClickListener {
            binding.cardView4.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.orange))
            binding.tvCard4.setTextColor(ContextCompat.getColor(applicationContext, R.color.orange))

            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard1.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard2.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))

            binding.cardView3.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            binding.tvCard3.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
    }

    private fun log(message: String) {
        Log.d(TAG, message)
    }
}