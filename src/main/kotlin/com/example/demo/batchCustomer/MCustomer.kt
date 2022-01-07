package com.example.demo.batchCustomer

import org.springframework.stereotype.Component

/**
 * 顧客情報管理クラス
 *
 * @property customerId 顧客ID
 * @property name 顧客名
 * @property address 住所
 */
@Component
data class MCustomer(var customerId: Int,var name: String,var address: String)
