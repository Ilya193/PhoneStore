package com.xlwe.phonestore.data.retrofit

import com.xlwe.phonestore.data.retrofit.model.HotSales
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiRequests {
    @Headers("x-apikey: 61ddae2e95cb716ea5ee48e4")
    @GET("/rest/home")
    fun getData(): Call<HotSales>
}