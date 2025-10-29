package com.example.componentes2.componentes

import androidx.compose.ui.graphics.vector.ImageVector

data class CheckInfo(
    val titulo: String,
    var seleccionado: Boolean = false,
    val icon: ImageVector? = null,
    var cambiado: (Boolean) -> Unit
)


data class CheckInfo2(
    val tituloIcono: TituloIcono,
    var seleccionado: Boolean = false,
    var cambiado: (Boolean) -> Unit
)


data class TituloIcono(
    val titulo: String,
    val icon: ImageVector? = null,
)

