package com.xlwe.phonestore.domain.hotsales

import androidx.lifecycle.MutableLiveData
import com.xlwe.phonestore.domain.model.HomeStore

class GetHotSalesListUseCase(private val hotSalesRepository: HotSalesRepository) {
    suspend fun getHotSalesList(_hotSales: MutableLiveData<List<HomeStore>>) {
        hotSalesRepository.getHotSalesList(_hotSales)
    }
}