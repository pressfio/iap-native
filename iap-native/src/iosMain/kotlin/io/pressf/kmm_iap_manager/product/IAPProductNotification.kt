package io.pressf.kmm_iap_manager.product

import platform.StoreKit.SKPaymentTransaction

actual class IAPProductNotification actual constructor (actual val type: IAPProductNotificationType, actual val error: String?) {

    var transaction: SKPaymentTransaction? = null
        private set

    constructor(type: IAPProductNotificationType, transaction: SKPaymentTransaction?, error: String?): this(type,error) {
        this.transaction = transaction
    }

}
