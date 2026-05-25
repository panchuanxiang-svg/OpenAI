package dev.bifrost.android.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bifrost.android.provider.OfficialFusProvider
import kotlinx.coroutines.launch

@Composable
fun FirmwareScreen() {

    val scope = rememberCoroutineScope()

    var model by remember {
        mutableStateOf("SM-S9180")
    }

    var region by remember {
        mutableStateOf("CHC")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Bifrost Android",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = model,
            onValueChange = {
                model = it
            },
            label = {
                Text("Model")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = region,
            onValueChange = {
                region = it
            },
            label = {
                Text("Region")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            scope.launch {

                try {

                    val provider = OfficialFusProvider()

                    val list = provider.search(
                        model,
                        region
                    )

                    result = list.joinToString("\n") {
                        it.url
                    }

                } catch (e: Exception) {

                    result = e.message ?: "Error"
                }
            }

        }) {
            Text("Search Firmware")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(result)
    }
}