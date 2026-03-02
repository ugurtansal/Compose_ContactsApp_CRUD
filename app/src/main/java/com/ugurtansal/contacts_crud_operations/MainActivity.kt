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
        searchCntacts()
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Contacts_CRUD_operationsTheme {
        Page()
    }
}