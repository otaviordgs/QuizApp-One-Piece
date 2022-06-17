package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import kotlinx.coroutines.selects.select

@Dao
interface DaoJogador {
    @Query("Select * from jogador")
    fun getAll(): List<Jogador>

    @Query("Select * from jogador where nome = :nome")
    fun getByUser(nome: String?): Jogador

    @Insert
    fun insert(user: Jogador)

    @Update
    fun update(user: Jogador)
}