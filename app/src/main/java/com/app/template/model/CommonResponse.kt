package com.app.template.model

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    @SerializedName("text") var text: String,
    @SerializedName("status") var status: String? = null,
    @SerializedName("message") var message: String? = null,
)
