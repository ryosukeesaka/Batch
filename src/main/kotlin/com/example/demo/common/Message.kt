package com.example.demo.common

import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import java.util.*

/**
 * メッセージ管理クラス
 *
 */
@Component
class Message(var messageSource: MessageSource) {

    /**
     * メッセージID情報定義
     */
    companion object {
        const val CMN_I_00000:String = "cmn.msg.CMN_I_00000"
        const val CMN_I_00001:String = "cmn.msg.CMN_I_00001"
    }

    /**
     * メッセージ取得
     *
     * @param msgKey メッセージID
     * @param msgParam メッセージ内容
     * @return 取得メッセージ
     */
    fun getMsg(msgKey:String, vararg msgParam:String): String{
        return messageSource.getMessage(msgKey, msgParam, Locale.JAPAN)
    }
}