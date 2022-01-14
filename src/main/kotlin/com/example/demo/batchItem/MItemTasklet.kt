package com.example.demo.batchItem

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.item.ItemStreamWriter
import org.springframework.batch.item.file.FlatFileHeaderCallback
import org.springframework.batch.item.file.FlatFileItemWriter
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor
import org.springframework.batch.item.file.transform.DelimitedLineAggregator
import org.springframework.batch.item.file.transform.FieldExtractor
import org.springframework.batch.item.file.transform.LineAggregator
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


/**
 * 商品情報移管タスクレットクラス
 *
 * @property mItemMapper 商品情報移管DBアクセスオブジェクト
 */
@Component
class MItemTasklet(var mItemMapper: MItemMapper): Tasklet {

    fun write() :FlatFileItemWriter<MItem> {
        val writer: FlatFileItemWriter<MItem> = FlatFileItemWriter<MItem>()
        //val write: FlatFileItemWriter<MItem>
        val outputResource: Resource = FileSystemResource("C:\\temp\\data.csv")

        writer.setResource(outputResource)
        writer.setEncoding("Shift-JIS")
        writer.setLineSeparator("\r\n")
        writer.setAppendAllowed(false)
        //オブジェクト式は、クラスの無名インスタンスを生成します。
        writer.setHeaderCallback(FlatFileHeaderCallback { arg0 -> arg0.append("\"ID\",\"商品名\",\"アーティスト名\",\"メールアドレス\"") })

        writer.setLineAggregator(object: DelimitedLineAggregator<MItem?>() {
            init{
                setDelimiter(",")
                setFieldExtractor(object: BeanWrapperFieldExtractor<MItem?>() {
                    init {
                        setNames(arrayOf("itemId", "itemName","artistName", "unitPrice"))
                    }
                })
            }
        })
        //writer.setLineAggregator(LineAggregator<MItem?>() {
//                init {
//                    setFieldExtractor(BeanWrapperFieldExtractor<MItem?>() {
//                        init {
//                            setNames(arrayOf("itemId", "itemName", "artistName","unitPrice"))
//                        }
//                    })
//                }
//            })


        return writer
    }

    @Transactional
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {

        val mItem = mItemMapper.findAll()

        val streamWriter: ItemStreamWriter<MItem> = write()
        streamWriter.open(chunkContext.getStepContext().getStepExecution().getExecutionContext())

        try {
            val data: MutableList<MItem> = ArrayList<MItem>()
            for (item in mItem) {
                data.add(item)
                println(data.size)
                if (data.size <= 1000) {
                    streamWriter.write(data)
                    data.clear()
                }
                if (data.size > 0) streamWriter.write(data)
            }
        }catch(e: Exception){

        }

        streamWriter.close()

        // 商品情報(移管先)全件削除
        mItemMapper.delete()

        // 商品情報(移管先)登録
        //mItemMapper.insertBulk(mItem)

        return RepeatStatus.FINISHED
    }
}