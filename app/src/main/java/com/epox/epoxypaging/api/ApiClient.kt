package com.epox.epoxypaging.api


import com.epox.epoxypaging.response.GetCharacterPageResponse
import retrofit2.Response

class ApiClient (
    private val apiInterface: ApiInterface
        ){

    suspend fun getCharactersPage(pageIndex: Int): SimpleResponse<GetCharacterPageResponse> {
       return safeApiCall {apiInterface.getCharactersPage(pageIndex)}
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}