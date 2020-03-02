package com.leandro.coroutinesroomdatabase.db

class SubscriberRepository(private val dao:SubscriberDao) {
    val subscribers = dao.getAll()

    suspend fun insert(subscriber: Subscriber){
        dao.insert(subscriber)
    }
    suspend fun clearAll(){
        dao.deleteAll()
    }
}