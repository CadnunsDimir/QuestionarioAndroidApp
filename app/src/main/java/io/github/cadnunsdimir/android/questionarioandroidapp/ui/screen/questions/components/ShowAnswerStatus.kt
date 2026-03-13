package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.questions.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionAnswerStatus

@Composable
fun ShowAnswerStatus(status: QuestionAnswerStatus, answer: String) {
    val color = if(status == QuestionAnswerStatus.CORRECT) Color.Green else Color.Red
    Text("A resposta está ${status.toString().uppercase()}! Resposta: $answer",
        color = color)
}