package com.xlwe.phonestore.domain.hotsales

import androidx.lifecycle.MutableLiveData
import com.xlwe.phonestore.domain.model.BestSeller

class GetBestSellerListUseCase(private val hotSalesRepository: HotSalesRepository) {
    suspend fun getBestSellerList(_bestSeller: MutableLiveData<List<BestSeller>>) {
        hotSalesRepository.getBestSellerList(_bestSeller)
    }
}