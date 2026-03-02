package com.ugurtansal.contacts_crud_operations.data.response

import android.os.Message
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUDResponse(
    @SerializedName("success")
    @Expose
    var success:Int,
    @SerializedName("message")
    @Expose
    var message: String
)
