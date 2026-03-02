package com.ugurtansal.contacts_crud_operations.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ugurtansal.contacts_crud_operations.data.entity.Contacts

data class ContactsResponse(
    @SerializedName("kisiler")
    @Expose
    var contacts: List<Contacts>,
    @SerializedName("success")
    @Expose
    var success: Int
)
