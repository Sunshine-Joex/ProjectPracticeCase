### ProjectPracticeCase

------------


该项目主要用来快速开发项目，一些常用的方法不需要再去麻烦google大佬

**tips: 以下是提供的调用方法，至于具体实现都在项目中**

#### 状态栏和导航栏

- 状态栏和导航栏颜色
 ```
setStatusBarColor(this, Color.CYAN)
setNavigationBarColor(this,Color.CYAN)
  ```
注意：你需要在activity/fragment的根布局添加：
```
android:fitsSystemWindows="true"
android:clipToPadding="true"
```
    否则，布局会上移

效果如下：

![此处为图片加载失败时显示的文字](https://raw.github.com/Sunshine-Joex/ProjectPracticeCase/master/raw/setNavigationStatusBarColor.png)

#### json解析工具

```
 注意：kotlin的常量在类的顶层
const val JSON = """{name:"zimo",age:"23"}"""
const val JSONARRAY = """[{"name":"乔","age":"21"},{"name":"sunshine","age":"25"}]"""

var user: User = toJsonObject(JSON, User::class.java)
Log.i("json", "user.name:${user.name}-user.age:${user.age}")

 var users: List<User> = toJsonList(JSONARRAY, User::class.java)
users.forEach {
    Log.i("json", "user.name:${it.name}-user.age:${it.age}")
}
```
