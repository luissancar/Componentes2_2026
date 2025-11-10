package com.example.componentes2.componentes

import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.roundToInt

@Composable
fun MySlider() {
    var sliderPos by remember() { mutableStateOf(0f) }
    Slider(
        value = sliderPos,
        onValueChange = { sliderPos = it })
    Text(sliderPos.toString())
}

@Composable
fun MySlider2() {
    var sliderPos by remember() { mutableStateOf(0f) }
    var completeValue by remember() { mutableStateOf("") }
    Slider(
        value = sliderPos,
        onValueChange = { sliderPos = it },
        onValueChangeFinished = {
            completeValue=sliderPos.roundToInt().toString()
        },
        valueRange = 0f..100f,
        steps = 9
        )
    Text(sliderPos.toString())
    Text(completeValue)


}


















