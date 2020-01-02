package com.example.mycpplib

class MyCppLib {

    external fun floatToInt(x: Float): Int
    external fun numberFromCPP(): Int

    companion object {




        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

}