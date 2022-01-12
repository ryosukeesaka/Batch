package com.example.demo.batchItem

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.file.FlatFileItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource


@EnableBatchProcessing
@Configuration
class MItemBatchConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val mItemTasklet: MItemTasklet,
    val mapper: MItemMapper
) {
    //val outputResource: Resource = FileSystemResource("C:\\Users\\ryosuke.esaka.yu\\Desktop\\SpringBatchSample\\demo\\src\\main\\resources")

//    @Bean
//    fun createDemoContext(): DemoContext? {
//        return DemoContext(1000)
//    }


//    fun write(): FlatFileItemWriter<MItem>? {
//        val writer: FlatFileItemWriter<MItem> = FlatFileItemWriter<MItem>()
//        writer.setResource(outputResource)
//        writer.setEncoding("UTF-8")
//        writer.setLineSeparator("\r\n")
//        writer.setAppendAllowed(false)
//        writer.setHeaderCallback { arg0 -> arg0.append("\"ID\",\"商品名\",\"アーティスト名\",\"単価\"") }
//        writer.setLineAggregator(object : CsvLineAggregator<MItem>()) {
//            init {
//                setFieldExtractor(object : BeanWrapperFieldExtractor<MItem?>() {
//                    init {
//                        setNames(arrayOf("itemId", "itemName", "artistName","unitPrice"))
//                    }
//                })
//            }
//        })
//        return writer
//    }
    /**
     * 商品情報移管ステップ定義
     *
     * @return 商品情報移管ステップオブジェクト
     */
    @Bean
    fun mItemStep(): Step = stepBuilderFactory.get("mItemStep").allowStartIfComplete(true).tasklet(mItemTasklet).build()

    /**
     * 商品情報移管ジョブ定義
     *
     * @return 商品情報移管ジョブオブジェクト
     */
    @Bean
    fun mItemJob(): Job? =
        jobBuilderFactory.get("mItemJob")
            .incrementer(RunIdIncrementer())
            .start(mItemStep())
            .build()
}