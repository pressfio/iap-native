package io.pressf.kmm_iap_manager.product

expect class IAPProduct {

    val id: String
    val localizedTitle: String
    val localizedPrice: String?
    val price: String

}