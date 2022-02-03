package com.xlwe.phonestore.di.domain

import com.xlwe.phonestore.domain.hotsales.GetBestSellerListUseCase
import com.xlwe.phonestore.domain.hotsales.GetHotSalesListUseCase
import com.xlwe.phonestore.domain.hotsales.HotSalesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetHotSalesListUseCase(hotSalesRepository: HotSalesRepository): GetHotSalesListUseCase {
        return GetHotSalesListUseCase(hotSalesRepository)
    }

    @Provides
    fun provideGetBestSellerListUseCase(hotSalesRepository: HotSalesRepository): GetBestSellerListUseCase {
        return GetBestSellerListUseCase(hotSalesRepository)
    }
}