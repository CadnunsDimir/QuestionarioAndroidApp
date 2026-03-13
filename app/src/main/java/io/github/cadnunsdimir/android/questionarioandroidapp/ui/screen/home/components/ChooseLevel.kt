package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionsLevel

@Composable
fun ChooseLevel(onChoose: (level: QuestionsLevel)-> Unit) {
    Column {
        Text("Escolha o nível de dificuldade")
        for (level in QuestionsLevel.entries) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {onChoose(level)}
            ) { Text("$level") }
        }
    }
}