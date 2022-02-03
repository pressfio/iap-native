package io.pressf.kmm_iap_manager.IAPProduct

internal actual data class IAPProductMetadata(
    actual val productId: String,
    actual val state: IAPProductState,
    actual val transactionId: String?
) {

    actual enum class Platform {
        IOS, Android
    }

    actual val platform: Platform = Platform.IOS

    actual fun completePurchase() { }

}
