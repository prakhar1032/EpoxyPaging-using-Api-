package com.epox.epoxypaging.api

import com.epox.epoxypaging.response.GetCharacterByIdResponse
import com.epox.epoxypaging.response.GetCharacterPageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//rick and mortyservice
interface ApiInterface {
    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ) : Response<GetCharacterByIdResponse>

    @GET("character")
    suspend fun getCharactersPage(
        @Query("page")pageIndex: Int
    ): Response<GetCharacterPageResponse>

}