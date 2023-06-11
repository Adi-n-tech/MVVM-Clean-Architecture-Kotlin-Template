package com.app.template.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.app.template.R
import com.app.template.databinding.ActivityDashboardBinding
import com.app.template.model.CommonResponse
import com.app.template.utils.network.NetworkResult
import com.app.template.viewmodel.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    private val dashboardViewModelNew by viewModels<DashboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)

        lifecycleScope.launch {
            dashboardViewModelNew.getApiConstants()
        }
        //----
        observeApiResult()
    }

    private fun observeApiResult() {
        dashboardViewModelNew.apiConstants.observe(this, Observer {
            when (it) {
                is NetworkResult.Success -> {
                    // -----
                    val constantResponse: CommonResponse = it.data as CommonResponse
                    Toast.makeText(this, constantResponse.text, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    // show progress
                    Toast.makeText(this, "Loading..", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}