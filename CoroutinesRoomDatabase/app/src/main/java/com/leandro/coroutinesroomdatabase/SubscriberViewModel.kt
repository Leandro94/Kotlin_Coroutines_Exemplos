package com.leandro.coroutinesroomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro.coroutinesroomdatabase.db.Subscriber
import com.leandro.coroutinesroomdatabase.db.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository):ViewModel() {
    val subscribers =  repository.subscribers

    fun insert(subscriber: Subscriber):Job =  viewModelScope.launch {
        repository.insert(subscriber)
    }
    fun clearAll(){
        viewModelScope.launch {
            repository.clearAll()
        }
    }

}