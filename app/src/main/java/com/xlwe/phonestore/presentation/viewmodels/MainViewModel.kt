package com.xlwe.phonestore.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xlwe.phonestore.domain.hotsales.GetBestSellerListUseCase
import com.xlwe.phonestore.domain.hotsales.GetHotSalesListUseCase
import com.xlwe.phonestore.domain.model.BestSeller
import com.xlwe.phonestore.domain.model.HomeStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHotSalesListUseCase: GetHotSalesListUseCase,
    private val getBestSellerListUseCase: GetBestSellerListUseCase
): ViewModel() {
    private val _hotSales = MutableLiveData<List<HomeStore>>()
    val hotSales: LiveData<List<HomeStore>>
        get() = _hotSales

    private val _bestSeller = MutableLiveData<List<BestSeller>>()
    val bestSeller: LiveData<List<BestSeller>>
        get() = _bestSeller

    fun getHotSalesList() {
        viewModelScope.launch {
            getHotSalesListUseCase.getHotSalesList(_hotSales)
        }
    }

    fun getBestSellerList() {
        viewModelScope.launch {
            getBestSellerListUseCase.getBestSellerList(_bestSeller)
        }
    }
}