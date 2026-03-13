package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionsLevel
import io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.home.components.ChooseLevel
import io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.home.components.ShowQuestions

@Composable
fun HomeScreen() {
    var level by remember { mutableStateOf(QuestionsLevel.Easy) }
    var showQuestions by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Text("Questionário",
            style = MaterialTheme.typography.titleLarge
        )

        if(!showQuestions)
            ChooseLevel { selected ->
                level = selected
                showQuestions = true
            }
        else {
            ShowQuestions(level)
            Button({
                showQuestions = false
            }) {
                Text("Voltar")
            }
        }
    }
}