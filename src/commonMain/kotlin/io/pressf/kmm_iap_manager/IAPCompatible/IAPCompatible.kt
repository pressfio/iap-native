package io.pressf.kmm_iap_manager.IAPCompatible

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct

interface IAPCompatible {

    annotation class T

    fun List<T>.fillWith(products: List<IAPProduct>)

}