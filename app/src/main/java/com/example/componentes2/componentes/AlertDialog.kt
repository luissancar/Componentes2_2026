package com.example.componentes2.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAlerDialog() {
    var openDialog by remember { mutableStateOf(true) }
    if (openDialog) {
        BasicAlertDialog(
            onDismissRequest = { openDialog = false },
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(Modifier.padding(30.dp)) {
                    Text(
                        text = "Hello",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(Modifier.height(10.dp))
                    TextButton(
                        onClick = { openDialog = false },
                        modifier = Modifier
                            .shadow(1.dp, shape = MaterialTheme.shapes.small)
                    ) {
                        Text("Ok")
                    }
                }
            }
        }
    }
    TextButton(
        onClick = { openDialog = true }
    ) {
        Text("Open dialog")
    }

}