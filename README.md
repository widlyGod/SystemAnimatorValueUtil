## 使用

* 系统中Animator时长缩放改变时，会改变app中的动画效果。
* 修改之后会影响Animator，不影响Animation。如果关闭动画，也会影响Lottie动画。

## 如何影响Animator

* 在创建窗口或者动画缩放改变之后，系统会调用ValueAnimator. setDurationScale设置app全局的缩放比例，并把值保存到sDurationScale。
* 在ValueAnimator.doAnimationFrame方法计算动画，获取经过缩放的时间间隔，如果时间间隔为0，则标记为结束，整个动画也就结束了。立刻触发AnimatorListener的onAnimationStart和onAnimationEnd方法

## 如何影响Lottie

* LottieAnimationView在初始化时会判断系统的缩放是否为0，并设置到LottieDrawable.systemAnimationsEnabled。
* 在调用playAnimation方法时，如果systemAnimationsEnabled为false则会直接直接调用endAnimation方法。立刻触发AnimatorListener的onAnimationStart和onAnimationEnd方法

