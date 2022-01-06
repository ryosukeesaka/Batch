package com.example.demo.batchItem

class MItem(itemId: Int,item_name: String,artist_name: String,unit_price: Int) {

    val itemId: Int
    val item_name: String
    val artist_name: String
    val unit_price: Int

    init {
        this.itemId = itemId
        this.item_name = item_name
        this.artist_name = artist_name
        this.unit_price = unit_price
    }

}