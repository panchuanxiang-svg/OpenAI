package com.samsung.firmware.downloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirmwareDownloaderApp()
                }
            }
        }
    }
}

@Composable
fun FirmwareDownloaderApp() {
    var model by remember { mutableStateOf("") }
    var region by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "三星固件下载器",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("设备型号") },
            placeholder = { Text("例: SM-G950F") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = region,
            onValueChange = { region = it },
            label = { Text("地区代码") },
            placeholder = { Text("例: DBT (德国)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = { isSearching = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            enabled = model.isNotEmpty() && region.isNotEmpty() && !isSearching
        ) {
            Icon(
                imageVector = Icons.Default.Download,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(if (isSearching) "搜索中..." else "搜索固件")
        }

        if (isSearching) {
            Spacer(modifier = Modifier.height(24.dp))
            CircularProgressIndicator(
                modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally)
            )
        }
    }
}
