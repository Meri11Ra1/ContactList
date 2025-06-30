package com.example.contactlist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.contactlist.Contact
import androidx.compose.material.icons.Icons 
import androidx.compose.material.icons.filled.Star

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(contacts: List<Contact>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("友人リスト") })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(contacts) { contact ->
                ContactListItem(contact = contact)
            }
        }
    }
}

@Composable
fun ContactListItem(contact: Contact) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(contact.iconUrl),
            contentDescription = "アイコン",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = contact.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = contact.phoneNumber, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        /*

         ↓ この部分をまるごと追加
        */
        if (contact.isFavorite) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "お気に入り",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}