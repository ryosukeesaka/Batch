package com.example.demo.batchCustomer

class MCustomer(customer_id: Int, name: String, address: String) {
    val customer_id: Int
    val name: String
    val address: String

    init {
        this.customer_id = customer_id
        this.name = name
        this.address = address
    }

}
