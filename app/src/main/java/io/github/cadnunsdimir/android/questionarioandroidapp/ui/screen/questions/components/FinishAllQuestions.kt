package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.questions.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionAnswerStatus
import kotlin.math.ceil

@Composable
fun FinishAllQuestions(questionsAnswered: MutableMap<Int, QuestionAnswerStatus>) {
    val correctAnswers = questionsAnswered.values.count { it == QuestionAnswerStatus.CORRECT }
    val percent = 100f / questionsAnswered.size * correctAnswers
    val percentAsInt = ceil(percent).toInt()
    val phrase = if(percent > 60f) "Você foi Ótimo!" else "Precisa estudar mais!"

    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Column (
            modifier = Modifier.padding(10.dp)
        ) {
            Text(phrase,
                style = MaterialTheme.typography.titleLarge
            )
            Text("Sua taxa de aproveitamento foi $percentAsInt %")
            Text("Você acertou $correctAnswers/${questionsAnswered.size} perguntas !")
        }

    }
}