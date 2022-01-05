package com.example.demo.batchOrder

import java.util.*

class TOrder(order_number: Int, order_date: Date,total_amount: Int,customer_id: String,payment_method: String) {
    val order_number: Int
    val order_date: Date
    val total_amount: Int
    val customer_id: String
    val payment_method: String

    init{
        this.order_number = order_number
        this.order_date = order_date
        this.total_amount = total_amount
        this.customer_id = customer_id
        this.payment_method = payment_method
    }
}