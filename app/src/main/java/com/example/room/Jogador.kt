package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.onepiecequiz.models.Pontuacao

@Entity
data class Jogador(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "nome")
    var nome: String?,

    @ColumnInfo(name = "pontuacao")
    var pontuacao: String?
)
