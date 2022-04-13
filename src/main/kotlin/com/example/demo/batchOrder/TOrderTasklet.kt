package com.example.demo.batchOrder

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * 注文情報移管タスクレットクラス
 *
 * @property tOrderMapper 注文情報移管DBアクセスオブジェクト
 */
@Component
class TOrderTasklet(var tOrderMapper: TOrderMapper): Tasklet {

    /**
     * 注文情報移管タスクレットメイン処理
     *
     * @param contribution
     * @param chunkContext
     * @return　再実行ステータス
     */
    @Transactional
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        // 顧客情報(移管元)全件取得
        val tOrder = tOrderMapper.findAll()
        for(t in 0..tOrder.size-1){
            println(tOrder[t])
        }
        // 顧客情報(移管先)全件削除
        tOrderMapper.delete()
        // 顧客情報(移管先)登録
        tOrderMapper.insertBulk(tOrder)

        return RepeatStatus.FINISHED
    }
}