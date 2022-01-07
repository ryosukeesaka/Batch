package com.example.demo.batchOrder

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * 注文詳細情報移管タスクレットクラス
 *
 * @property tOrderDetailMapper 注文詳細情報移移管DBアクセスオブジェクト
 */
@Component
class TOrderDetailTasklet(var tOrderDetailMapper: TOrderDetailMapper): Tasklet {


    /**
     * 注文詳細情報移管タスクレットメイン処理
     *
     * @param contribution
     * @param chunkContext
     * @return　再実行ステータス
     */
    @Transactional
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {

        val tOrderDetail = tOrderDetailMapper.findAll()

        tOrderDetailMapper.delete()

        tOrderDetailMapper.insertBulk(tOrderDetail)

        return RepeatStatus.FINISHED
    }
}