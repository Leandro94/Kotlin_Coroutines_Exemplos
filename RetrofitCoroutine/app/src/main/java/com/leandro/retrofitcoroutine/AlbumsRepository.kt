package com.leandro.retrofitcoroutine

import com.leandro.retrofitcoroutine.retrofit.Album
import com.leandro.retrofitcoroutine.retrofit.AlbumService
import com.leandro.retrofitcoroutine.retrofit.RetrofitInstance

class AlbumsRepository {
    var albumService: AlbumService = RetrofitInstance.albumService

    suspend fun getAlbum(albumId: Int): Album = albumService.getAlbum(albumId)
}