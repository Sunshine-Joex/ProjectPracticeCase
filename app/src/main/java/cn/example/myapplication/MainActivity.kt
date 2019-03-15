package cn.example.myapplication

import android.graphics.Color
import android.view.View
import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.base.BaseContract
import cn.example.myapplication.bean.User
import cn.example.myapplication.extension.startActivity
import cn.example.myapplication.ui.TestActivity
import cn.example.myapplication.utils.SharedPreferences
import cn.example.myapplication.utils.setStatusBarColor
import cn.example.myapplication.utils.toJsonArray
import cn.example.myapplication.utils.toJsonObject
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */

class MainActivity : BaseActivity<BaseContract.BasePresenter>(), View.OnClickListener {
    var isLogin: Boolean by SharedPreferences.preference(this, "islogin", false)
    val json: String = "{\"name\":\"name0\",\"age\":\"0\"}"
    val jsonArray: String = "[{\"name\":\"name1\",\"age\":\"intvalue\"},{\"name\":\"name2\",\"age\":\"intvalue\"},{\"name\":\"name3\",\"age\":\"intvalue\"}]"
    override fun getLayout() = R.layout.activity_main
    override fun initView() {
        super.initView()
        setStatusBarColor(this, Color.CYAN)
        val user: User = toJsonObject(json, User::class.java)
        val users: List<User> = toJsonArray(jsonArray, User::class.java)
        print(user.toString())
        print(users.toString())
    }

    override fun onResume() {
        super.onResume()

        testNetView.setOnClickListener(this)
        imageTopStatusBar.setOnClickListener(this)
        isLogin = true

    }


    override fun setStatusBarBlack(): Boolean {
        return true
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.testNetView -> startActivity<TestActivity>()
            R.id.imageTopStatusBar -> startActivity<ImageTopActivity>()

        }
    }


}
