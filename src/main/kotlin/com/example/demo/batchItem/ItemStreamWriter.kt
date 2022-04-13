package com.example.demo.batchItem

import org.springframework.batch.item.ItemStream
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
interface ItemStreamWriter<MItem> : ItemStream, ItemWriter<MItem> {


}