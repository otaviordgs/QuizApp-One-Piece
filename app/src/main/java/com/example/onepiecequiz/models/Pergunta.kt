package com.example.onepiecequiz.models

data class Pergunta(
    val id: Int,
    val pergunta: String,
    val imagem: Int,
    val alternativaUm: String,
    val alternativaDois: String,
    val alternativaTres: String,
    val alternativaQuatro: String,
    val alternativaCinco: String,
    val resposta: Int
)
