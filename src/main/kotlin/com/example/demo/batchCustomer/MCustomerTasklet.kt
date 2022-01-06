package com.example.demo.batchCustomer

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class MCustomerTasklet(var mCustomerMapper:  MCustomerMapper): Tasklet  {

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {

        //全件取得
        var mCustomerList = mCustomerMapper.findAll()

        //顧客テーブル2削除
        mCustomerMapper.delete()

        //顧客テーブル、データ挿入
        for (i in mCustomerList.indices) {
            mCustomerMapper.insert(mCustomerList[i].customerId,mCustomerList[i].name,mCustomerList[i].address)
        }
        //var mCustomer2List = mCustomerMapper.insert()
        return RepeatStatus.FINISHED
    }
}
