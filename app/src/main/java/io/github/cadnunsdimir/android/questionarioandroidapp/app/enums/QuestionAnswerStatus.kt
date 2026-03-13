package io.github.cadnunsdimir.android.questionarioandroidapp.app.enums

enum class QuestionAnswerStatus(val label: String) {
    CORRECT ("Correta"),
    INCORRECT("Incorreta"),
    AWAITING_ANSWER("Aguardando resposta");
    override fun toString(): String {
        return label
    }
}