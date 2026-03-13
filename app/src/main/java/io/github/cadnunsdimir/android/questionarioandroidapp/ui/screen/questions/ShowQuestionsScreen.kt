package io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.questions

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionAnswerStatus
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionsLevel
import io.github.cadnunsdimir.android.questionarioandroidapp.app.repository.QuestionsRepository
import io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.questions.components.FinishAllQuestions
import io.github.cadnunsdimir.android.questionarioandroidapp.ui.screen.questions.components.QuestionForm

@Composable
fun ShowQuestionsScreen(level: QuestionsLevel) {
    val questions = QuestionsRepository.listByLevel(level)
    val questionsAnswered = remember { mutableStateMapOf<Int, QuestionAnswerStatus>() }

    if(questionsAnswered.values.size < questions.size) {
        Column (){
            Text("Nível $level",
                style = MaterialTheme.typography.titleLarge
            )

            for (questionNumber in 1..questions.size){
                val question = questions[questionNumber -1]
                QuestionForm(questionNumber, question) {
                    questionsAnswered.put(questionNumber, it)
                }
            }
        }
    } else {
        FinishAllQuestions(questionsAnswered)
    }
}