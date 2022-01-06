package com.example.demo.batchCustomer

class MCustomer2 {

    var customerId: Int = 0
    var name: String = ""
    var address: String = ""

    fun MCustomer(
        customerId: Int,
        name: String,
        address: String
    ) {
        this.customerId = customerId
        this.name = name
        this.address = address
    }
}