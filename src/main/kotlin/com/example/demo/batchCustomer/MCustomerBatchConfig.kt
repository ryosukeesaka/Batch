package com.example.demo.batchCustomer


import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * 顧客情報移管バッチ定義クラス
 *
 * @property jobBuilderFactory ジョブ構築オブジェクト
 * @property stepBuilderFactory ステップ構築オブジェクト
 * @property mCustomerTasklet 顧客情報移管タスクレットオブジェクト
 * @property mapper　顧客情報移管DBアクセスオブジェクト
 */
@EnableBatchProcessing
@Configuration
class MCustomerBatchConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val mCustomerTasklet: MCustomerTasklet,
    val mapper: MCustomerMapper
) {
    /**
     * 顧客情報移管ステップ定義
     *
     * @return 顧客情報移管ステップオブジェクト
     */
    @Bean
    fun mCustomerStep(): Step = stepBuilderFactory.get("mCustomerStep").allowStartIfComplete(true).tasklet(mCustomerTasklet).build()

    /**
     * 顧客情報移管ジョブ定義
     *
     * @return 顧客情報移管ジョブオブジェクト
     */
    @Bean
    fun mCustomerJob(): Job? =
        jobBuilderFactory.get("mCustomerJob")
        .incrementer(RunIdIncrementer())
        .start(mCustomerStep())
        .build()
}