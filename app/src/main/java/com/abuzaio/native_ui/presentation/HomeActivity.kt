package com.abuzaio.native_ui.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.abuzaio.native_ui.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeView by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.states.observe(this, Observer { state ->
            when (state) {
                is HomeViewState.Loading -> pb_home.visibility = View.VISIBLE
                is HomeViewState.Success -> {
                    pb_home.visibility = View.GONE
                    rv_home.addItemDecoration(
                        DividerItemDecoration(
                            this@HomeActivity,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                    rv_home.adapter = HomeAdapter(state.response.results)
                }
                is HomeViewState.Error -> {
                    pb_home.visibility = View.GONE
                    Log.e(HomeActivity::class.java.simpleName, "${state.error.printStackTrace()}")
                }
            }
        })

        viewModel.discoverMovie()
    }
}