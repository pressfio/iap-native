package io.pressf.kmm_iap_manager.product

expect enum class IAPProductNotificationType {

    ProductWasPurchased,
    ProductWasDeferred,
    ProductPurchaseFailed,
    ProductWasRestored,
    ProductIsPurchasing;

    companion object

}