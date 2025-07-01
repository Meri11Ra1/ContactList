package com.example.contactlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contactlist.data.sampleContacts
import com.example.contactlist.ui.ContactListScreen
import com.example.contactlist.ui.theme.ContactListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactApp()
                }
            }
        }
    }
}

@Composable
fun ContactApp() {
    ContactListScreen(contacts = sampleContacts)

    // test
    // これが見えたらmainブランチは最新です（7/1のみやそうより）
}