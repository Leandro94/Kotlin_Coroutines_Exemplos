package com.leandro.coroutinesroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leandro.coroutinesroomdatabase.db.AppDatabase
import com.leandro.coroutinesroomdatabase.db.Subscriber
import com.leandro.coroutinesroomdatabase.db.SubscriberRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = AppDatabase.getInstance(applicationContext).subscriberDao
        val repository = SubscriberRepository(dao)
        val viewModelFactory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this,viewModelFactory).get(SubscriberViewModel::class.java)
        displaySubscriberList()

        btnSalvar.setOnClickListener{
            val subscriber = Subscriber(0,edtNome.text.toString(), edtEmail.text.toString())
            subscriberViewModel.insert(subscriber)
        }
        btnLimpar.setOnClickListener{
            subscriberViewModel.clearAll()
        }
    }

    private fun displaySubscriberList(){
        subscriberViewModel.subscribers.observe(this, Observer {
            textViewInscritos.text =  it.toString()
        })
    }
}
