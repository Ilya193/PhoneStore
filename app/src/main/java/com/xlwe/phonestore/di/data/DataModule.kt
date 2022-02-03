package com.xlwe.phonestore.di.data

import com.xlwe.phonestore.data.hotsales.HotSalesRepositoryImpl
import com.xlwe.phonestore.data.retrofit.ApiRequests
import com.xlwe.phonestore.domain.hotsales.HotSalesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {
    @Provides
    fun provideHotSalesRepository(apiRequests: ApiRequests): HotSalesRepository {
        return HotSalesRepositoryImpl(apiRequests)
    }
}