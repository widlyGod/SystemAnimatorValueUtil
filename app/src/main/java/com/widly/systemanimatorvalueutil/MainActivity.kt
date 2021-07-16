package com.widly.systemanimatorvalueutil

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textAnimator()
        btn_animator_value.setOnClickListener {
            ValueAnimatorUtil().resetDurationScaleIfDisable()
            textAnimator()
        }
    }

    private fun textAnimator(){
        val animator = ObjectAnimator.ofFloat(tv_hello_world, "rotation", 0f, 360f)
        animator.duration = 5000
        animator.start()
    }
}