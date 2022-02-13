package io.pressf.kmm_iap_manager.product

data class IAPProductNotification(
    val type: IAPProductNotificationType,
    val product: IAPProduct?,
    val error: String?
)
