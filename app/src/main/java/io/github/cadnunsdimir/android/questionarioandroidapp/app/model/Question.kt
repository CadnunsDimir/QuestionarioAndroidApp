package io.github.cadnunsdimir.android.questionarioandroidapp.app.model

import android.R
import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionsLevel

data class Question(
    val questionText: String,
    val multipleChoices: List<String>,
    val answer: String,
    val level: QuestionsLevel)
