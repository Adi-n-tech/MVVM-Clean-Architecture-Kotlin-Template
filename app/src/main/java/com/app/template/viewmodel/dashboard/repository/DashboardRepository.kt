package com.app.template.viewmodel.dashboard.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.template.model.CommonResponse
import com.app.template.utils.network.NetworkResult
import com.app.template.viewmodel.dashboard.api.DashboardService
import com.google.gson.JsonObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardRepository @Inject constructor(
    private val dashboardService: DashboardService
) {
    // api constants
    private val _apiConstants = MutableLiveData<NetworkResult<CommonResponse>>()
    val apiConstants: LiveData<NetworkResult<CommonResponse>> get() = _apiConstants


    suspend fun getApiConstants() {
        _apiConstants.postValue(NetworkResult.Loading())
        //-----
       /* val jsonObject = JsonObject()
        jsonObject.addProperty("userId", userId)
        jsonObject.addProperty("apiToken", "dnnksd")*/
        val response = dashboardService.getApiConstants()
        if (response.isSuccessful && response.body() != null) {
            _apiConstants.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            _apiConstants.postValue(NetworkResult.Error(response.errorBody().toString()))
        } else {
            _apiConstants.postValue(NetworkResult.Error("Something went wrong !!"))
        }
    }
}