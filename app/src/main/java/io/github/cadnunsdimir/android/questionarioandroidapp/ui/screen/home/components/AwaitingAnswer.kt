package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionAnswerStatus
import io.github.cadnunsdimir.android.questionarioandroidapp.app.model.Question

@Composable
fun AwaitingAnswer(question: Question,
                   onChoice: (status: QuestionAnswerStatus)-> Unit) {
    if (question.multipleChoices.isNotEmpty()) {
        question.multipleChoices.forEach {
            val letter = getLetterByNumber(
                question.multipleChoices.indexOf(it) + 1
            ).uppercase()

            val optionText = it

            Button(
                {
                    val status = if (optionText == question.answer)  QuestionAnswerStatus.CORRECT else QuestionAnswerStatus.INCORRECT
                    onChoice(status)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("$letter) $optionText")
            }
        }
    } else {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            text,
            onValueChange = { text = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    val status = if (text == question.answer)  QuestionAnswerStatus.CORRECT else QuestionAnswerStatus.INCORRECT
                    onChoice(status)
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
    )
}

fun getLetterByNumber(n: Int): Char {
    return ('A'.code + (n - 1)).toChar()
}