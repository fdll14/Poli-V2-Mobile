package com.dhani.poli.api.response

import com.google.gson.annotations.SerializedName

data class Default(
    @SerializedName("gender")
    var gender:String?,
    @SerializedName("Accuracy")
    var Accuracy:String?,
    @SerializedName("Message")
    var message:String?
)
