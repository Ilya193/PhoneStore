package com.xlwe.phonestore.data.hotsales

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xlwe.phonestore.data.retrofit.ApiRequests
import com.xlwe.phonestore.data.retrofit.model.HotSalesMapper
import com.xlwe.phonestore.domain.hotsales.HotSalesRepository
import com.xlwe.phonestore.domain.model.BestSeller
import com.xlwe.phonestore.domain.model.HomeStore
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.awaitResponse
import javax.inject.Inject

class HotSalesRepositoryImpl @Inject constructor(
    private val apiRequests: ApiRequests,
): HotSalesRepository {
    private val mapper = HotSalesMapper()
    private val hotSalesPhone = MutableLiveData<List<HomeStore>>()
    private val hotSalesList = mutableListOf<HomeStore>()
    private val bestSellerList = mutableListOf<BestSeller>()

    override suspend fun getHotSalesList(_hotSales: MutableLiveData<List<HomeStore>>) {
        val response = apiRequests.getData().awaitResponse()

        if (response.isSuccessful) {
            val data = response.body()!!
            data[0].home_store.forEach {
                hotSalesList.add(mapper.mapDbModelToEntity(it))
            }
            _hotSales.value = hotSalesList.toList()
        }
    }

    override suspend fun getBestSellerList(_bestSeller: MutableLiveData<List<BestSeller>>) {
        val response = apiRequests.getData().awaitResponse()

        if (response.isSuccessful) {
            val data = response.body()!!
            data[0].best_seller.forEach {
                bestSellerList.add(mapper.mapDbModelToEntity(it))
            }
            _bestSeller.value = bestSellerList.toList()
        }
    }
}