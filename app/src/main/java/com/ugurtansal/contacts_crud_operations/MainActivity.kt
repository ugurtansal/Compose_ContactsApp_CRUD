package com.ugurtansal.contacts_crud_operations

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ugurtansal.contacts_crud_operations.data.response.CRUDResponse
import com.ugurtansal.contacts_crud_operations.data.response.ContactsResponse
import com.ugurtansal.contacts_crud_operations.retrofit.ApiUtils
import com.ugurtansal.contacts_crud_operations.retrofit.ContactsDao
import com.ugurtansal.contacts_crud_operations.ui.theme.Contacts_CRUD_operationsTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Contacts_CRUD_operationsTheme {
                Page()
            }
        }
    }
}

@Composable
fun Page() {

    LaunchedEffect(Unit) {
        insertCntacts()
    }

}


fun allCOntacts() {
    val contactsDao = ApiUtils.getContactsDao()

    contactsDao.allContacts().enqueue(object : Callback<ContactsResponse> {
        override fun onResponse(
            call: Call<ContactsResponse>,
            response: Response<ContactsResponse>
        ) {

            val list=response.body().contacts

            list.forEach {item->
                Log.e("Contact Info","**************************")
                Log.e("Contact ID",item.contactId.toString())
                Log.e("Contact Name",item.contactName)
                Log.e("Contact Number",item.contactNumber)
            }

        }

        override fun onFailure(call: Call<ContactsResponse?>?, t: Throwable?) {}

    })
}


fun searchCntacts() {
    val contactsDao = ApiUtils.getContactsDao()

    contactsDao.searchContact("t").enqueue(object : Callback<ContactsResponse> {
        override fun onResponse(
            call: Call<ContactsResponse>,
            response: Response<ContactsResponse>
        ) {

            val list=response.body().contacts

            list.forEach {item->
                Log.e("Contact Info","**************************")
                Log.e("Contact ID",item.contactId.toString())
                Log.e("Contact Name",item.contactName)
                Log.e("Contact Number",item.contactNumber)
            }

        }

        override fun onFailure(call: Call<ContactsResponse?>?, t: Throwable?) {}

    })
}


fun deleteAContact() {
    val contactsDao = ApiUtils.getContactsDao()

    contactsDao.deleteContact(19307).enqueue(object : Callback<CRUDResponse> {
        override fun onResponse(
            call: Call<CRUDResponse>,
            response: Response<CRUDResponse>
        ) {

            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null) {
                // Body null değilse işlemleri yap
                val success = responseBody.success.toString()
                val message = responseBody.message ?: "Mesaj yok"

                Log.e("Message Success", success)
                Log.e("Message Delete", message)
            } else {
                // Sunucu hata döndürdüyse (404, 500 vb.) veya body boşsa
                Log.e("Error", "Sunucudan boş veya hatalı yanıt geldi: ${response.code()}")
            }


        }

        override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}

    })
}

fun insertCntacts() {
    val contactsDao = ApiUtils.getContactsDao()

    contactsDao.insertContact("Selim","25658423").enqueue(object : Callback<CRUDResponse> {
        override fun onResponse(
            call: Call<CRUDResponse>,
            response: Response<CRUDResponse>
        ) {

            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null) {
                // Body null değilse işlemleri yap
                val success = responseBody.success.toString()
                val message = responseBody.message ?: "Mesaj yok"

                Log.e("Message Success", success)
                Log.e("Message Delete", message)
            } else {
                // Sunucu hata döndürdüyse (404, 500 vb.) veya body boşsa
                Log.e("Error", "Sunucudan boş veya hatalı yanıt geldi: ${response.code()}")
            }


        }

        override fun onFailure(call: Call<CRUDResponse?>?, t: Throwable?) {}

    })
}


fun updateCntacts() {
    val contactsDao = ApiUtils.getContactsDao()

    contactsDao.updateContact(1365,"Selim","25658423").enqueue(object : Callback<CRUDResponse> {
        override fun onResponse(
            call: Call<CRUDResponse>,
            response: Response<CRUDResponse>
        ) {

            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null) {
                // Body null değilse işlemleri yap
                val success = responseBody.success.toString()
                val message = responseBody.message ?: "Mesaj yok"

                Log.e("Message Success", success)
                Log.e("Message Delete", message)
            } else {
                // Sunucu hata döndürdüyse (404, 500 vb.) veya body boşsa
                Log.e("Error", "Sunucudan boş veya hatalı yanıt geldi: ${response.code()}")
            }


        }

        override fun onFailure(call: Call<CRUDResponse?>?, t: Throwable?) {}

    })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Contacts_CRUD_operationsTheme {
        Page()
    }
}