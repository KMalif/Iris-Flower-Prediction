package com.kmalif.iris.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class History:RealmObject() {
    private var id : Int? = null
    private var sLength : String? = null
    private var sWidth : String? = null
    private var pLength : String? = null
    private var pWidth : String? = null
    private var result : String? = null

    fun setId (id:Int){
        this.id = id
    }
    fun getId (): Int?{
        return id
    }

    fun setSLength (slength:String){
        this.sLength = sLength
    }
    fun getSLength (): String?{
        return sLength
    }

    fun setSWidth (sWidth:String){
        this.sWidth = sWidth
    }
    fun getSWidth (): String?{
        return sWidth
    }

    fun setPLength (plength:String){
        this.pLength = pLength
    }
    fun getPLength (): String?{
        return pLength
    }

    fun setPWidth (pWidth:String){
        this.pWidth = pWidth
    }
    fun getPWidth (): String?{
        return pWidth
    }

    fun setResult(result : String){
        this.result = result
    }
    fun getResult(): String?{
        return result
    }

}