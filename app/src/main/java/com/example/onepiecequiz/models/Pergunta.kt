package com.example.onepiecequiz.models

data class Pergunta(
    val id: Int = 0,
    val pergunta: String? = null,
    val imagem: Int = 0,
    val alternativaUm: String? = null,
    val alternativaDois: String? = null,
    val alternativaTres: String? = null,
    val alternativaQuatro: String? = null,
    val alternativaCinco: String? = null,
    val resposta: Int = 0,
    val dica: String? = null
)
