package com.example.contactlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactlist.data.sampleContacts
import com.example.contactlist.ui.ContactDetailScreen
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
    val navController = rememberNavController()

    // NavHostで画面遷移を管理
    NavHost(navController = navController, startDestination = "contact_list") {
        // ルートページ (連絡先リスト画面)
        composable("contact_list") {
            // 他のファイルから関数をインポートして呼び出す
            ContactListScreen(navController = navController, contacts = sampleContacts)
        }
        // 詳細ページ
        composable(
            route = "contact_detail/{contactId}",
            arguments = listOf(navArgument("contactId") { type = NavType.IntType })
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            // sampleContactsも他のファイルからインポート
            val contact = sampleContacts.find { it.id == contactId }
            if (contact != null) {
                // 他のファイルから関数をインポートして呼び出す
                ContactDetailScreen(navController = navController, contact = contact)
            }
        }
    }
}