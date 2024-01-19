package fr.mastersid.toure.stackoverflow.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UpdateWeatherButton(updateQuestion: () -> Unit, modifier: Modifier) {
    Button(
        onClick = updateQuestion , modifier = modifier
    ){
        Text("Update question")
    } }
