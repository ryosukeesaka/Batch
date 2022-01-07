package com.example.demo.batchCustomer

import org.apache.ibatis.annotations.Mapper

/**
 * 顧客情報移管DBアクセスクラス
 *
 */
@Mapper
interface MCustomerMapper {
    /**
     * 顧客情報(移管元)全件取得
     *
     * @return 顧客情報リスト
     */
    fun findAll(): List<MCustomer>

    /**
     * 顧客情報(移管元)全件削除
     *
     */
    fun delete()

    /**
     * 顧客情報(移管先)登録
     *
     * @param MCustomer 顧客情報リスト
     */
    fun insertBulk(MCustomer: List<MCustomer>)
}