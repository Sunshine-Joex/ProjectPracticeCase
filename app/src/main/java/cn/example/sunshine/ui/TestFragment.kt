package cn.example.sunshine.ui



import cn.example.sunshine.R
import cn.example.sunshine.base.BaseFragment
import cn.example.sunshine.bean.HolidayBean
import cn.example.sunshine.ui.contract.TestContract
import cn.example.sunshine.ui.presenter.TestPresenter

class TestFragment : BaseFragment<TestPresenter>(), TestContract.View {
    override fun showEmpty() {
    }


    override fun loadData(holiday: HolidayBean) {

     }


    override fun getLayout(): Int =R.layout.fragment_test


 }
