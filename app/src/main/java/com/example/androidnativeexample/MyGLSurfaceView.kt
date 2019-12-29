package com.example.androidnativeexample

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent

class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {

    private val renderer: MyGLRenderer

    private var mPreviousX: Float = 0.toFloat()
    private var mPreviousY: Float = 0.toFloat()
    private val TOUCH_SCALE_FACTOR = 180.0f / 320

    init {

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2)

        renderer = MyGLRenderer(context)

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                val dx = x - mPreviousX
                val dy = y - mPreviousY
                renderer.mAngleX += dx * TOUCH_SCALE_FACTOR
                renderer.mAngleY += dy * TOUCH_SCALE_FACTOR
                requestRender()
            }
        }
        mPreviousX = x
        mPreviousY = y
        return true
    }
}