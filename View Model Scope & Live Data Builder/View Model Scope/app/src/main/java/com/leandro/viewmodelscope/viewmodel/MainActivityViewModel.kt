package com.leandro.viewmodelscope.viewmodel

import androidx.lifecycle.*
import com.leandro.viewmodelscope.model.User
import com.leandro.viewmodelscope.model.UserRespository
import kotlinx.coroutines.*

class MainActivityViewModel: ViewModel() {
    private var userRepository = UserRespository()

    //Live Data Builder
    var users = liveData(Dispatchers.IO){
        val result = userRepository.getUsers()
        emit(result)
    }


    /*
    //Life Cycle ----------------------------------------------------------------------------
    var users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var resultado : List<User>? =null
             withContext(Dispatchers.IO){
                 resultado = userRepository.getUsers()
             }
            users.value = resultado
        }
    }*/

}