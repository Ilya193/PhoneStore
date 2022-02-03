package com.xlwe.phonestore.domain.hotsales

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xlwe.phonestore.domain.model.BestSeller
import com.xlwe.phonestore.domain.model.HomeStore

interface HotSalesRepository {
    suspend fun getHotSalesList(_hotSales: MutableLiveData<List<HomeStore>>)
    suspend fun getBestSellerList(_bestSeller: MutableLiveData<List<BestSeller>>)
}