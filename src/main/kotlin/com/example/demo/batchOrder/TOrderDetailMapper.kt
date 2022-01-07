package com.example.demo.batchOrder
import org.apache.ibatis.annotations.Mapper

/**
 * 注文詳細情報移管DBアクセスクラス
 *
 */
@Mapper
interface TOrderDetailMapper {

    /**
     * 注文詳細情報(移管元)全件取得
     *
     * @return 注文詳細情報リスト
     */
    fun findAll(): List<TOrderDetail>

    /**
     * 注文詳細情報(移管元)全件削除
     *
     */
    fun delete()

    /**
     * 注文詳細情報(移管先)登録
     *
     * @param TOrderDetail 注文詳細情報リスト
     */
    fun insertBulk(TOrderDetail: List<TOrderDetail>)
}