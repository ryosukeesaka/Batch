package com.example.demo.batchOrderDetail

class TOrderDetail(order_number: Int,item_id: Int,amount: Int) {
    val order_number: Int
    val item_id: Int
    val amount: Int

    init{
        this.order_number = order_number
        this.item_id = item_id
        this.amount = amount
    }
}