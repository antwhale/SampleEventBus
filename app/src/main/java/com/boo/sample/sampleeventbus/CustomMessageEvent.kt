package com.boo.sample.sampleeventbus

class CustomMessageEvent {
    private var customMessage: String? = null

    fun getCustomMessage(): String{
        return customMessage ?: ""
    }

    fun setCustomMessage(value :String){
        this.customMessage = value
    }

}
