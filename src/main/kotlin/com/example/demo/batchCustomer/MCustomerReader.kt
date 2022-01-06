package com.example.demo.batchCustomer

//import org.graalvm.compiler.loop.InductionVariable
//import org.springframework.batch.item.ItemReader
//import org.springframework.batch.item.NonTransientResourceException
//import org.springframework.batch.item.UnexpectedInputException
//import org.springframework.batch.item.data.RepositoryItemReader
//
//
//class MCustomerReader(val mapper: MCustomerMapper) : ItemReader<MCustomer?> {
//    val reader: RepositoryItemReader<MCustomer> = RepositoryItemReader<MCustomer>()
//    reader.setRepository(mapper)
//    reader.setMethodName("findAll")
//    val sort: MutableMap<String, InductionVariable.Direction> = HashMap()
//    sort["name"] = Direction.ASC
//    reader.setSort(sort)
//    return reader
//}