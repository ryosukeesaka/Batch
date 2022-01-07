package com.example.demo.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * ログ出力管理クラス
 *
 */
class Logger {
    companion object {
        // ログ出力オブジェクト
        private val logger: Logger = LoggerFactory.getLogger(this::class.java.enclosingClass)

        /**
         * デバッグログ出力
         *
         * @param msgParam メッセージ内容
         */
        fun debug(msgParam:String){
            logger.debug(msgParam)
        }

        /**
         * 情報ログ出力
         *
         * @param msgParam メッセージ内容
         */
        fun info(msgParam:String){
            logger.info(msgParam)
        }

        /**
         * 警告ログ出力
         *
         * @param msgParam メッセージ内容
         */
        fun warn(msgParam:String){
            logger.warn(msgParam)
        }

        /**
         * エラーログ出力
         *
         * @param msgParam メッセージ内容
         */
        fun error(msgParam:String){
            logger.error(msgParam)
        }
    }
}