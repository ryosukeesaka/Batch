package com.example.demo.batchCustomer

import org.springframework.boot.autoconfigure.domain.EntityScan

@EntityScan
class MCustomer {
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
