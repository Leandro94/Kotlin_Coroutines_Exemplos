package com.leandro.retrofitcoroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class MainActivityViewModel: ViewModel() {

    val albumsRepository = AlbumsRepository()
    val album = liveData{
        val receivedAlbum = albumsRepository.getAlbum(5)
        emit(receivedAlbum)
    }
}