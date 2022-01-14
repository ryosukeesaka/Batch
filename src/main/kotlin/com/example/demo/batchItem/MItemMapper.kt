package com.example.demo.batchItem

import org.apache.ibatis.annotations.Mapper

@Mapper
interface MItemMapper {

    fun findAll(): List<MItem>

    fun delete()

    //fun insertBulk(MItem: List<MItem>)
}