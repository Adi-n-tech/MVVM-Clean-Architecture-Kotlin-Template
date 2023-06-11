package com.app.template.viewmodel.dashboard.api

import com.app.template.model.CommonResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DashboardService {

 /*   @POST("random")
    suspend fun getApiConstants(@Body jsonObject: JsonObject?): Response<CommonResponse>*/

    @GET("random")
    suspend fun getApiConstants(): Response<CommonResponse>
}