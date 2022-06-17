package com.example.onepiecequiz.models
import com.example.onepiecequiz.R


object PerguntaSingleton {

    const val Acertos: String = ""
    const val Pontos: String = ""
    fun getPerguntas(): ArrayList<Pergunta> {
        val perguntas = ArrayList<Pergunta>()

        val pergunta1 = Pergunta(
            1, "Qual o nome do \"Haki do Rei\" em japonês?", R.drawable.haki_rei,
            "Kenbushoku Haki", "Busoshoku Haki", "Haoshoku Haki",
            "Gear", "Bound Man", 1,"Tem Haki no nome"
        )
        perguntas.add(pergunta1)

        val pergunta2 = Pergunta(
            2, "Qual o nome do arco que Robin chora?", R.drawable.robin_chorando,
            "Alabasta", "SkyPiea", "Enies lobby",
            "Whole Cake", "Water 7", 3,"Na saga Water 7"
        )
        perguntas.add(pergunta2)

        val pergunta3 = Pergunta(
            3, "Como era chamado o Haki de observação pelo Enel?", R.drawable.haki_observacao,
            "Guia", "Mantra", "Visão", "Haki",
            "Observação", 2,"Lembra do Izaias"
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
            4,
            "Que gelo...."
        )
        perguntas.add(pergunta4)

        val pergunta5 = Pergunta(
            5, "No arco Thriller Bark, qual o nome da fruta da Perona?", R.drawable.perona,
            "Horo Horo no Mi", "Gomu Gomu no Mi", "Bari Bari no Mi",
            "Soru Soru no Mi", "Pika Pika no Mi", 1,"Nossa que Horror!"
        )
        perguntas.add(pergunta5)

        val pergunta6 = Pergunta(
            5, "Quantos Shichibukais Luffy enfrentou até o time skip?", R.drawable.shitibukai,
            "6", "8", "5",
            "7", "2", 5,"Menos que 8"
        )
        perguntas.add(pergunta6)

        val pergunta7 = Pergunta(
            5, "Qual o nome do avô do Luffy?", R.drawable.garp,
            "Dragon", "Shanks", "Roger",
            "Garp", "Ace", 4, "É da marinha"
        )
        perguntas.add(pergunta7)

        val pergunta8 = Pergunta(
            5, "Qual é o nome da Ilha onde os gigantes Dorry e Broggy lutavam?", R.drawable.gigantes,
            "Little Garden", "ILha de Jaya", "Punk Hazard",
            "Ilha de Fuscha", "Ilha das Marés ", 1,"É o inverso deles"
        )
        perguntas.add(pergunta8)

        val pergunta9 = Pergunta(
            5, "No Arquipélago de Sabaody, qual dos 11 supernovas tem a recompensa mais alta?",
            R.drawable.supernovas,
            "Law", "Luffy", "Kid",
            "Apoo", "Killer", 3,"É o mais locão"
        )
        perguntas.add(pergunta9)

        val pergunta10 = Pergunta(
            5, "Zoro possui qual espada de Oden?",
            R.drawable.zoro,
            "Nodachi", "Habakiri", "Shikomizue",
            "Yubashiri", "Enma", 5,"Lembra um animal"
        )
        perguntas.add(pergunta10)
        perguntas.shuffle()
        return perguntas
    }
}