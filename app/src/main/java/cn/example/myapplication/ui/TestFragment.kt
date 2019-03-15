package cn.example.myapplication.ui



import cn.example.myapplication.R
import cn.example.myapplication.base.BaseFragment
import cn.example.myapplication.bean.HolidayBean
import cn.example.myapplication.ui.contract.TestContract
import cn.example.myapplication.ui.presenter.TestPresenter
import cn.example.myapplication.utils.SharedPreferences

class TestFragment : BaseFragment<TestPresenter>(), TestContract.View {


     override fun loadData(holiday: HolidayBean) {

     }


    override fun getLayout(): Int =R.layout.fragment_test


 }
