package com.example.onepiecequiz.models
import com.example.onepiecequiz.R


object PerguntaSingleton {
    fun getPerguntas(): ArrayList<Pergunta> {
        val perguntas = ArrayList<Pergunta>()

        val pergunta1 = Pergunta(
            1, "Qual o nome do \"Haki do Rei\" em japonês?", R.drawable.haki_rei,
            "Kenbushoku Haki", "Busoshoku Haki", "Haoshoku Haki",
            "Gear", "Bound Man", 1
        )
        perguntas.add(pergunta1)

        val pergunta2 = Pergunta(
            2, "Qual o nome do arco que Robin chora?", R.drawable.robin_chorando,
            "Alabasta", "SkyPiea", "Enies lobby",
            "Whole Cake", "Water 7", 3
        )
        perguntas.add(pergunta2)

        val pergunta3 = Pergunta(
            3, "Como era chamado o Haki de observação pelo Enel?", R.drawable.haki_observacao,
            "Guia", "Mantra", "Visão", "Haki",
            "Observação", 2
        )
        perguntas.add(pergunta3)

        val pergunta4 = Pergunta(
            4,
            "Como era chamado o amigo de Franky, também discípulo de Tom," +
                    "o famoso construtor naval?",
            R.drawable.iceburg,
            "Yokozuna",
            "Rob Lucci",
            "Kokoro",
            "Iceburg",
            "Kaku",
            4
        )
        perguntas.add(pergunta4)

        val pergunta5 = Pergunta(
            5, "No arco Thriller Bark, qual o nome da fruta da Perona?", R.drawable.perona,
            "Horo Horo no Mi", "Gomu Gomu no Mi", "Bari Bari no Mi",
            "Soru Soru no Mi", "Pika Pika no Mi", 1
        )
        perguntas.add(pergunta5)

        perguntas.shuffle()
        return perguntas
    }
}