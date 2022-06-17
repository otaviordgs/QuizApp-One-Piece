package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Jogador::class), version = 1)
abstract class MainDatabase: RoomDatabase() {
    abstract fun jogadorDao():DaoJogador
}