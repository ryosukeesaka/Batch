package com.example.demo.batchOrder

import java.util.*

/**
 * TODO
 *
 * @property orderNumber
 * @property orderDate
 * @property totalAmount
 * @property customerId
 * @property paymentMethod
 */
data class TOrder(
    var orderNumber: Int,
    var orderDate: Date,
    var totalAmount: Int,
    var customerId: Int,
    var paymentMethod: String,
) {

}