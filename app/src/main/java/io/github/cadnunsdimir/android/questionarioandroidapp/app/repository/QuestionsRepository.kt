package io.github.cadnunsdimir.android.questionarioandroidapp.app.repository

import io.github.cadnunsdimir.android.questionarioandroidapp.app.enums.QuestionsLevel
import io.github.cadnunsdimir.android.questionarioandroidapp.app.model.Question

class QuestionsRepository {
    companion object {
        fun listByLevel(level: QuestionsLevel): List<Question> {
            return db.filter { it.level == level }
        }
        val db = listOf(

            Question(
                "Qual é o apelido mais famoso da cidade de São Paulo?",
                listOf(
                    "Cidade Maravilhosa",
                    "Terra da Garoa",
                    "Cidade do Sol"
                ),
                "Terra da Garoa",
                QuestionsLevel.Easy
            ),

            Question(
                "Qual é o nome da principal avenida financeira de São Paulo, conhecida por concentrar bancos e empresas?",
                emptyList(),
                "Avenida Paulista",
                QuestionsLevel.Easy
            ),

            Question(
                "Qual destes rios passa pela cidade de São Paulo?",
                listOf(
                    "Rio Amazonas",
                    "Rio Tietê",
                    "Rio São Francisco"
                ),
                "Rio Tietê",
                QuestionsLevel.Easy
            ),

            Question(
                "Em que ano a cidade de São Paulo foi fundada?",
                listOf(
                    "1500",
                    "1554",
                    "1822"
                ),
                "1554",
                QuestionsLevel.Medium
            ),

            Question(
                "Qual é o parque urbano mais famoso e visitado de São Paulo, localizado próximo à Avenida Paulista?",
                emptyList(),
                "Parque Ibirapuera",
                QuestionsLevel.Medium
            ),

            Question(
                "Qual é o bairro tradicional conhecido pela forte influência da cultura japonesa em São Paulo?",
                emptyList(),
                "Liberdade",
                QuestionsLevel.Medium
            ),

            Question(
                "Qual instituição fundou a cidade de São Paulo em 1554?",
                listOf(
                    "Bandeirantes",
                    "Jesuítas",
                    "Portugueses comerciantes"
                ),
                "Jesuítas",
                QuestionsLevel.Hard
            ),

            Question(
                "Qual é o nome do colégio onde foi celebrada a missa que marcou a fundação da cidade de São Paulo?",
                emptyList(),
                "Colégio de São Paulo",
                QuestionsLevel.Hard
            ),

            Question(
                "Qual é o nome do edifício histórico famoso pelo mirante que permite ver grande parte do centro de São Paulo?",
                listOf(
                    "Edifício Copan",
                    "Edifício Itália",
                    "MASP"
                ),
                "Edifício Itália",
                QuestionsLevel.Hard
            )
        )
    }

}