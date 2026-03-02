package com.ugurtansal.contacts_crud_operations.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Contacts(
    @SerializedName("kisi_id")
    @Expose
    var contactId:Int,
    @SerializedName("kisi_ad")
    @Expose
    var contactName: String,
    @SerializedName("kisi_tel")
    @Expose
    var contactNumber: String,
)
