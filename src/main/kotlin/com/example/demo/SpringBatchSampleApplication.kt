package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * SpringBootアプリケーションクラス
 *
 */
@SpringBootApplication
class SpringBatchSampleApplication

/**
 * メイン処理
 *
 * @param args 実行引数
 */
fun main(args: Array<String>) {
	runApplication<SpringBatchSampleApplication>(*args)
}
