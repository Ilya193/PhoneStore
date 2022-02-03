package com.xlwe.phonestore.data.retrofit.model

class HotSalesMapper {
    fun mapDbModelToEntity(hotSalesDbModel: HomeStore) = com.xlwe.phonestore.domain.model.HomeStore(
        id = hotSalesDbModel.id,
        is_buy = hotSalesDbModel.is_buy,
        is_new = hotSalesDbModel.is_new,
        picture = hotSalesDbModel.picture,
        subtitle = hotSalesDbModel.subtitle,
        title = hotSalesDbModel.title,
    )

    fun mapDbModelToEntity(bestSellerDbModel: BestSeller) = com.xlwe.phonestore.domain.model.BestSeller(
        discount_price = bestSellerDbModel.discount_price,
        id = bestSellerDbModel.id,
        is_favorites = bestSellerDbModel.is_favorites,
        picture = bestSellerDbModel.picture,
        price_without_discount = bestSellerDbModel.price_without_discount,
        title = bestSellerDbModel.title,
    )
}