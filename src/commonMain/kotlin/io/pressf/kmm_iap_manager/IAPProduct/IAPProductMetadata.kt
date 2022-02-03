package io.pressf.kmm_iap_manager.IAPProduct

internal expect class IAPProductMetadata {

    enum class Platform {
        IOS,
        Android
    }

    val productId: String
    val state: IAPProductState
    val transactionId: String?
    val platform: Platform

    fun completePurchase()

}


