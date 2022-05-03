package io.pressf.kmm_iap_manager.product

expect class IAPProductNotification(type: IAPProductNotificationType, error: String?) {

    val type: IAPProductNotificationType
    val error: String?

}
