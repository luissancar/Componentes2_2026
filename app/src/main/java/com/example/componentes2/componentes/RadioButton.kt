package com.example.componentes2.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButton1() {
    var selecte by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selecte,
            onClick = { selecte = !selecte },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Magenta

            )
        )
        Text("RadioButton")
    }
}

@Composable
fun MyRadioButton2() {
    var selecte by remember { mutableStateOf("a") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selecte == "a",
            onClick = { selecte = "a" }
        )
        Text("a")
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selecte == "b",
            onClick = { selecte = "b" }
        )
        Text("b")
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selecte == "c",
            onClick = { selecte = "c" }
        )
        Text("c")
    }

}


@Composable
fun MyRadioButton3() {
    var selecte by remember { mutableStateOf("a") }

    RadioButtonItem("a", selecte = selecte) { selecte = it }
    RadioButtonItem("b", selecte = selecte) { selecte = it }
    RadioButtonItem("c", selecte = selecte) { selecte = it }
    RadioButtonItem("d", selecte = selecte) { selecte = it }

    Text(selecte)
}

@Composable
fun RadioButtonItem(valor: String, selecte: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selecte == valor,
            onClick = { onItemSelected(valor) }
        )

        Text(valor)
    }

}


@Composable
fun MyRadioButton4() {

    var selecte by remember { mutableStateOf("a") }
    //val options = listOf("a", "b", "c", "d")
    val options =('a'..'j').map {it.toString()}

    options.forEach {
        RadioButtonItem(it, selecte) { selecte = it }
    }
}










































