package com.example.componentes2.componentes

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MyBadgeBox() {
    var contador by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(100)
           if ( contador++ >100)
               contador=0
        }
    }
    BadgedBox(
        badge = {
            Badge(

                contentColor = Color.Red,
                containerColor = Color.Blue
            )
            {
                Text(text = contador.toString(), fontSize = 10.sp)
            }
        }
    ) {
        Icon(modifier = Modifier.width(80.dp).height(80.dp),
            imageVector = Icons.Default.Home,
            contentDescription = "Home"
        )
    }
}