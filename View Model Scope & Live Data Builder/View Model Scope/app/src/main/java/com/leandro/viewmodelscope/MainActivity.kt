package com.leandro.viewmodelscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leandro.viewmodelscope.model.UserRespository
import com.leandro.viewmodelscope.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //Comentado para utilizar Live Data
        //viewModel.getUserData()

        viewModel.users.observe(this, Observer {
            myUsers->myUsers.forEach {
            Log.d("XXX","nome ${it.name}")
        }
        })
    }
}
