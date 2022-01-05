package com.example.demo.batchItem

class MItem(item_id: Int,item_name: String,artist_name: String,unit_price: Int) {

    val item_id: Int
    val item_name: String
    val artist_name: String
    val unit_price: Int

    init {
        this.item_id = item_id
        this.item_name = item_name
        this.artist_name = artist_name
        this.unit_price = unit_price
    }

}