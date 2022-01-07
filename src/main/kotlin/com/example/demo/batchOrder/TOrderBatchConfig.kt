package com.example.demo.batchOrder

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.job.builder.FlowBuilder
import org.springframework.batch.core.job.flow.Flow
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor

/**
 * TODO
 *
 * @property jobBuilderFactory
 * @property stepBuilderFactory
 * @property tOrderTasklet
 * @property tOrderDetailTasklet
 */
@EnableBatchProcessing
@Configuration
class TOrderBatchConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val tOrderTasklet: TOrderTasklet,
    val tOrderDetailTasklet: TOrderDetailTasklet
) {

    /**
     * 受注情報移管ステップ定義
     *
     * @return 受注情報移管ステップオブジェクト
     */
    @Bean
    fun tOrderStep(): Step = stepBuilderFactory.get("tOrderStep").allowStartIfComplete(true).tasklet(tOrderTasklet).build()

    /**
     * 受注詳細情報移管ステップ定義
     *
     * @return　受注詳細情報移管ステップオブジェクト
     */
    @Bean
    fun tOrderDetailStep(): Step = stepBuilderFactory.get("tOrderDetailStep").allowStartIfComplete(true).tasklet(tOrderDetailTasklet).build()

    /**
     * 受注情報/受注詳細情報移管ジョブ定義
     *
     * @return　受注情報/受注詳細情報移管ジョブオブジェクト
     */
    @Bean
    @Throws(Exception::class)
    fun tOrderJob(tOrderStep: Step, tOrderDetailStep: Step): Job? {
        val flow: Flow = FlowBuilder<Flow>("flow")
            .start(FlowBuilder<Flow>("tOrderStep")
            .from(tOrderStep).end())
            .split(SimpleAsyncTaskExecutor())
            .add(FlowBuilder<Flow>("tOrderDetailStep")
            .from(tOrderDetailStep)
            .end())
            .build()
        return jobBuilderFactory["tOrderJob"]
            .incrementer(RunIdIncrementer())
            .start(flow)
            .end()
            .build()
    }
}
