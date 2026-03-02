package com.ugurtansal.contacts_crud_operations.retrofit

import com.ugurtansal.contacts_crud_operations.data.response.ContactsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ContactsDao {

    @GET("kisiler/tum_kisiler.php")
    fun allContacts(): Call<ContactsResponse>
}