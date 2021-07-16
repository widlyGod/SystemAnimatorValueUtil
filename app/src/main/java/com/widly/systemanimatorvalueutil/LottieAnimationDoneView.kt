package com.widly.systemanimatorvalueutil

import android.content.Context
import android.util.AttributeSet
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import java.lang.reflect.Field

/**
 *
 * @Description:     java类作用描述
 * @Author:         洪扬
 * @CreateDate:     2021/5/15 4:55 下午
 */
class LottieAnimationDoneView : LottieAnimationView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun playAnimation() {
        var lottieAnimationView = this::class.java.superclass
        var field: Field = lottieAnimationView.getDeclaredField("lottieDrawable")
        field.isAccessible = true
        (field.get(this) as LottieDrawable).setIgnoreDisabledSystemAnimations(true)
        super.playAnimation()
    }
}