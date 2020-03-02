package com.leandro.coroutinesroomdatabase.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SubscriberDao {
    @Insert
    suspend fun  insert(subscriber: Subscriber)

    @Query("DELETE FROM subscriber")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber")
    fun getAll(): LiveData<List<Subscriber>>
}