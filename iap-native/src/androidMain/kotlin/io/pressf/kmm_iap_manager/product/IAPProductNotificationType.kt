package io.pressf.kmm_iap_manager.product

actual enum class IAPProductNotificationType {

    ProductWasPurchased,
    ProductWasDeferred,
    ProductPurchaseFailed,
    ProductWasRestored,
    ProductIsPurchasing;

    actual companion object {}

}