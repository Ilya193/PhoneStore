package com.xlwe.phonestore.data.retrofit.model

data class HotSalesItem(
    val _id: String,
    val best_seller: List<BestSeller>,
    val home_store: List<HomeStore>
)