package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionAnswerStatus
import io.github.cadnunsdimir.android.questionarioandroidapp.app.model.Question

@Composable
fun QuestionForm(
    questionNumber: Int,
    question: Question,
    onAnswer: (status: QuestionAnswerStatus)-> Unit) {
    var questionStatus by remember { mutableStateOf(QuestionAnswerStatus.AWAITING_ANSWER) }
    Column {
        Text(
            "Pergunta $questionNumber: ${question.questionText}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        if (questionStatus == QuestionAnswerStatus.AWAITING_ANSWER) {
            AwaitingAnswer(question) {
                questionStatus = it
            }
        } else {
            ShowAnswerStatus(questionStatus, question.answer)
            onAnswer(questionStatus)
        }
    }
}

