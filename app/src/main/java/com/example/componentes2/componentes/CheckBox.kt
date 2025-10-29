package com.example.componentes2.componentes


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MyCheckBoxMain() {
    var status1 by rememberSaveable { mutableStateOf(false) }
    var status2 by rememberSaveable { mutableStateOf(false) }
    var status3 by rememberSaveable { mutableStateOf(false) }
    val checkInfo1 = CheckInfo(
        "uno",
        status1,
        cambiado = { status1 = it })
    val checkInfo2 = CheckInfo(
        "uno",
        status2,
        cambiado = { status2 = it })
    val checkInfo3 = CheckInfo(
        "uno",
        status3,
        cambiado = { status3 = it })
    MyCheckBoxF(checkInfo1)
    MyCheckBoxF(checkInfo2)
    MyCheckBoxF(checkInfo3)
    if (status1)
        Text("Uno")
    if (status2)
        Text("Dos")
    if (status3)
        Text("Tres")
}

@Composable
fun MyCheckBoxMain2() {
    val titulos = listOf("Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis")
    val iconos = listOf(
        Icons.Default.Home,
        Icons.Default.Add,
        Icons.Default.Check,
        Icons.Default.AddCircle,
        Icons.Default.AccountBox,
        Icons.Default.ArrowDropDown
    )
    val titulosIconos = listOf(
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add)
    )

    // Lista con estado y callbacks que se actualizan a sí mismos
    val opciones = remember {
        mutableStateListOf<CheckInfo>().apply {
            titulos.forEachIndexed { i, titulo ->
                add(
                    CheckInfo(
                        titulo = titulo,
                        icon = iconos.getOrNull(i),
                        seleccionado = false,
                        cambiado = { checked ->
                            // actualizar este elemento en la lista
                            this[i] = this[i].copy(seleccionado = checked)
                        }
                    )
                )
            }
        }
    }

    Column {
        opciones.forEach { item ->
            MyCheckBoxF(item)
        }
        Spacer(Modifier.height(12.dp))
        opciones.forEach {
            if (it.seleccionado) Text(it.titulo)
        }
    }
}



@Composable
fun MyCheckBoxMain3() {
    val titulosIconos = GetOptions2(listOf(
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
        TituloIcono("Uno", Icons.Default.Home),
        TituloIcono("Dos", Icons.Default.Add),
    )
    )

    Column {
        titulosIconos.forEach {
            MyCheckBoxF2(it)
        }
        titulosIconos.forEach {
            if (it.seleccionado)
                Text(it.tituloIcono.titulo)
        }
    }
}



@Composable
fun MyCheckBoxF2(checkInfo: CheckInfo2) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.seleccionado,
            onCheckedChange = { checkInfo.cambiado(!checkInfo.seleccionado) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Black
            )
        )
        Text(checkInfo.tituloIcono.titulo)
        // Icono (si viene)
        checkInfo.tituloIcono.icon?.let {
            Icon(
                it,
                contentDescription = null
            )
            Spacer(Modifier.width(8.dp))
        }
    }
}


@Composable
fun GetOptions2(titulosIconos: List<TituloIcono>): List<CheckInfo2> {
    return titulosIconos.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo2(
            tituloIcono = it,
            seleccionado = status,
            cambiado = { status = it })
    }
}


@Composable
fun GetOptions(titulos: List<String>): List<CheckInfo> {
    return titulos.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            titulo = it,
            seleccionado = status,
            cambiado = { status = it })
    }
}


@Composable
fun MyCheckBoxF(checkInfo: CheckInfo) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.seleccionado,
            onCheckedChange = { checkInfo.cambiado(!checkInfo.seleccionado) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Black
            )
        )
        Text(checkInfo.titulo)
        // Icono (si viene)
        checkInfo.icon?.let {
            Icon(
                it,
                contentDescription = null
            )
            Spacer(Modifier.width(8.dp))
        }
    }
}