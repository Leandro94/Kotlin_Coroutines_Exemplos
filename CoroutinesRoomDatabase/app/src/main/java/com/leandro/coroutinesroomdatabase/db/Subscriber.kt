package com.leandro.coroutinesroomdatabase.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "nome")
    var nome: String,

    @ColumnInfo(name = "email")
    var email: String


) {
    override fun toString(): String {
        return "\n nome='$nome', \n email='$email'"
    }
}