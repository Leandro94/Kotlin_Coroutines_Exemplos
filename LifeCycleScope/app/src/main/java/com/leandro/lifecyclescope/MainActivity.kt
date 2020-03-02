package com.leandro.lifecyclescope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.leandro.lifecyclescope.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
        lifecycleScope.launch(Dispatchers.IO){
           Log.d("XXX","thread is: ${Thread.currentThread().name}")
        }
        lifecycleScope.launchWhenCreated(){

        }
        lifecycleScope.launchWhenStarted(){

        }
        lifecycleScope.launchWhenResumed(){

        }
    }
}
