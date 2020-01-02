package com.example.androidnativeexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidnativeexample.openCV.OpenCVMainActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mycpplib.MyCppLib;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method

        val f = 21.1f
        val myCppLib = MyCppLib()

        numberToCpp.text = myCppLib.floatToInt(f).toString()
        numberFromCpp.text = myCppLib.numberFromCPP().toString()

        nextTaskButton.setOnClickListener {
            val intent = Intent(this@MainActivity, OpenCVMainActivity::class.java);
            startActivity(intent);
        }
    }

    companion object {

        init {
        }
    }
}
