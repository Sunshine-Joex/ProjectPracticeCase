### ProjectPracticeCase

------------


该项目主要用来快速开发项目，一些常用的方法不需要再去麻烦google大佬

**tips: 以下是提供的调用方法，至于具体实现都在项目中**

#### 状态栏和导航栏

- 状态栏颜色

    setStatusBarColor(this, Color.CYAN)
    
    注意：你需要在activity/fragment的根布局添加：
    ```
       android:fitsSystemWindows="true"
       android:clipToPadding="true"
    ```
    否则，布局会上移

效果如下：

![此处为图片加载失败时显示的文字](https://raw.github.com/Sunshine-Joex/ProjectPracticeCase/master/raw/setStatusBarColor.png)
