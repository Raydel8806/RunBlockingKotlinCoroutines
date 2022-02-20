package com.campingstudio.runblockingkotlincoroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.campingstudio.runblockingkotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG="Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG,"Before run-blocking")

        runBlocking()
        {
            Log.d(TAG,"just entered into the runBlocking ")
            delay(5000)
            val time = 1000L

            for (i in 2..6){
            launch(Dispatchers.IO)
                {
                    delay(time*(7-i))
                    Log.d(TAG,"Finished to coroutine $i")
                }
            }
            Log.d(TAG,"start of the run-blocking")
            Log.d(TAG,"End of the runBlocking")
        }
        Log.d(TAG,"after the run blocking")
        GlobalScope.launch()
        {
            Log.d(TAG,"Logging in the globalScope")
        }
    }

}

