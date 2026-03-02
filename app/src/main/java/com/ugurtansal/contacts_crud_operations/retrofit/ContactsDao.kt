package com.ugurtansal.contacts_crud_operations.retrofit

import com.ugurtansal.contacts_crud_operations.data.response.ContactsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ContactsDao {

    @GET("kisiler/tum_kisiler.php")
    fun allContacts(): Call<ContactsResponse>


    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded //Türkçe karekter desteği
    fun searchContact(@Field("kisi_ad") searchedValue: String): Call<ContactsResponse>
}