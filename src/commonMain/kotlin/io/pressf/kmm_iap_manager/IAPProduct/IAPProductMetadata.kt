package io.pressf.kmm_iap_manager.IAPProduct

data class IAPProductMetadata(
    val productId: String,
    val state: IAPProductState,
    val transactionId: String?
)
