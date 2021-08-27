package com.abuzaio.native_ui.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.abuzaio.native_ui.R
import com.abuzaio.native_ui.data.Result
import com.abuzaio.native_ui.databinding.ActivityHomeBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeViewModelCallback {
    @Inject
    lateinit var viewModel: HomeViewModel

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
            this,
            R.layout.activity_home
        ).apply {
            viewModel = this@HomeActivity.viewModel
        }.also {
            viewModel.discoverMovie()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDetach()
    }

    override fun onSuccess(results: List<Result>) {
        binding.rvHome.addItemDecoration(
            DividerItemDecoration(
                this@HomeActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvHome.adapter = HomeAdapter(results)
    }

    override fun onError(error: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
    }
}