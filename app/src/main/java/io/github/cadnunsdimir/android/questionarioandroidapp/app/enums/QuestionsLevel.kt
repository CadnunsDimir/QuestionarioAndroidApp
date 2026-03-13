package io.github.cadnunsdimir.android.questionarioandroidapp.app.enums

enum class QuestionsLevel(val label: String) {
    Easy("Fácil"),
    Medium("Médio"),
    Hard("Difícil");

    override fun toString(): String {
        return label
    }
}