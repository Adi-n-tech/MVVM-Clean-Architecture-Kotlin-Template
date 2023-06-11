package com.app.template.viewmodel.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.template.model.CommonResponse
import com.app.template.utils.network.NetworkResult
import com.app.template.viewmodel.dashboard.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepositoryNew: DashboardRepository
) : ViewModel() {

    val apiConstants: LiveData<NetworkResult<CommonResponse>> get() = dashboardRepositoryNew.apiConstants

    fun getApiConstants() {
        viewModelScope.launch {
            dashboardRepositoryNew.getApiConstants()
        }
    }
}