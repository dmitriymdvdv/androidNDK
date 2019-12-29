package com.example.androidnativeexample

import android.content.Context
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

import android.opengl.GLSurfaceView
import java.io.BufferedReader
import java.io.InputStreamReader

class MyGLRenderer(context: Context) : GLSurfaceView.Renderer {
    var mAngleX: Float = 0.toFloat()
    var mAngleY: Float = 0.toFloat()
    private var mContext: Context


    init {
        mContext = context
    }

    //Called once to set up the view's OpenGL ES environment.
    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {
        val vetexShaderStr = LoadShaderStr(mContext, R.raw.vshader)
        val fragmentShaderStr = LoadShaderStr(mContext, R.raw.fshader)
        naInitGL20(vetexShaderStr, fragmentShaderStr)
    }

    //Called for each redraw of the view.
    override fun onDrawFrame(gl: GL10) {
        naDrawGraphics(mAngleX, mAngleY)
    }

    //Called if the geometry of the view changes, for example when the device's
    //screen orientation changes.
    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        naSurfaceChanged(width, height)
    }

    private fun LoadShaderStr(context: Context, resId: Int): String {
        val strBuf = StringBuffer()
        try {
            val inputStream = context.resources.openRawResource(resId)
            // setup Bufferedreader
            val `in` = BufferedReader(InputStreamReader(inputStream))
            var read: String? = `in`.readLine()
            while (read != null) {
                strBuf.append(read + "\n")
                read = `in`.readLine()
            }
            strBuf.deleteCharAt(strBuf.length - 1)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return strBuf.toString()
    }

    private external fun naInitGL20(vertexShaderStr: String, fragmentShaderStr: String)
    private external fun naDrawGraphics(angleX: Float, angleY: Float)
    private external fun naSurfaceChanged(width: Int, height: Int)

    companion object {
        init {
            System.loadLibrary("CubeG2");
        }
    }
}