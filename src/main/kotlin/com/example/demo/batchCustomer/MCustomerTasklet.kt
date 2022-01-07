package com.example.demo.batchCustomer

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * 顧客情報移管タスクレットクラス
 *
 * @property mCustomerMapper 顧客情報移管DBアクセスオブジェクト
 */
@Component
class MCustomerTasklet(var mCustomerMapper:  MCustomerMapper): Tasklet  {

    /**
     * 顧客情報移管タスクレットメイン処理
     *
     * @param contribution
     * @param chunkContext
     * @return　再実行ステータス
     */
    @Transactional
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        // 顧客情報(移管元)全件取得
        val mCustomer = mCustomerMapper.findAll()

        // 顧客情報(移管先)全件削除
        mCustomerMapper.delete()

        // 顧客情報(移管先)登録
        mCustomerMapper.insertBulk(mCustomer)

        return RepeatStatus.FINISHED
    }
}
