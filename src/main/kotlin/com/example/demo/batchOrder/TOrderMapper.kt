package com.example.demo.batchOrder

import org.apache.ibatis.annotations.Mapper

/**
 * 注文情報移管DBアクセスクラスdes
 *
 */
@Mapper
interface TOrderMapper {

    /**
     * 注文情報(移管元)全件取得
     *
     * @return 注文詳細情報リスト
     */
    fun findAll(): List<TOrder>

    /**
     * 注文情報(移管元)全件削除
     *
     */
    fun delete()

    /**
     * 注文情報(移管先)登録
     *
     * @param TOrder 注文情報リスト
     */
    fun insertBulk(TOrder: List<TOrder>)
}