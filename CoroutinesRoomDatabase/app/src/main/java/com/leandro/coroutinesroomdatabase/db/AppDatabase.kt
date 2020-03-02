package com.leandro.coroutinesroomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Subscriber::class],version=1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract val subscriberDao: SubscriberDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase?=null

        fun getInstance(context: Context): AppDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "subscriber"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance

            }
        }
    }
}