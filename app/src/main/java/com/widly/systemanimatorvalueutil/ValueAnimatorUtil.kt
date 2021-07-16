package com.widly.systemanimatorvalueutil

import java.lang.reflect.Method


/**
 *
 * @Description:    修改全局动画速度
 * @Author:         洪扬
 * @CreateDate:     2021/5/15 10:43 上午
 */
class ValueAnimatorUtil {
    /**
     * 如果动画被禁用，则重置动画缩放时长
     */
    open fun resetDurationScaleIfDisable() {
        try {
            val valueAnimatorClass = Class.forName("android.animation.ValueAnimator")
            var valueAnimator = valueAnimatorClass.newInstance()
            val getAuthor: Method = valueAnimatorClass.getDeclaredMethod("getDurationScale")
            getAuthor.isAccessible = true
            var s = getAuthor.invoke(valueAnimator) as Float //使用方法
            if(s!=1f) {
                val setAuthor: Method =
                    valueAnimatorClass.getDeclaredMethod("setDurationScale", Float::class.java)
                setAuthor.isAccessible = true
                setAuthor.invoke(valueAnimator, 1f)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}