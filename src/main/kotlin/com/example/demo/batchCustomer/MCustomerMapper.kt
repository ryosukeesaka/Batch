package com.example.demo.batchCustomer

import org.apache.ibatis.annotations.Mapper

@Mapper
public interface MCustomerMapper {

    fun findAll(): List<MCustomer>
    fun delete()
    //fun insert(customer_id:Int,name: String,address: String)
    fun insertBulk(MCustomer: List<MCustomer>)
}