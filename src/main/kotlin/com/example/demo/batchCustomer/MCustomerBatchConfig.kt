package com.example.demo.batchCustomer


import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.data.RepositoryItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.batch.api.chunk.ItemReader


@EnableBatchProcessing
@Configuration
class MCustomerBatchConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val mCustomerTasklet: MCustomerTasklet,
    val mapper: MCustomerMapper
) {
    @Bean
    fun mCustomerStep(): Step = stepBuilderFactory.get("mCustomerStep").allowStartIfComplete(true).tasklet(mCustomerTasklet).build()

    @Bean
    fun mCustomerJob(): Job? =
        jobBuilderFactory.get("mCustomerJob")
        .incrementer(RunIdIncrementer())
        .start(mCustomerStep())
        .build()

//    @Bean
//    fun sourceItemReader(): ItemReader<MCustomer>? {
//        val reader: RepositoryItemReader<MCustomer> = RepositoryItemReader<MCustomer>()
//        reader.setRepository(mapper)
//        reader.setMethodName("findAll")
//        val sort: MutableMap<String, Direction> = HashMap()
//        sort["name"] = Direction.ASC
//        reader.setSort(sort)
//        return reader
//    }
}