package com.epox.epoxypaging

import com.epox.epoxypaging.api.NetworkLayer
import com.epox.epoxypaging.response.GetCharacterPageResponse


class CharactersRepository {

    suspend fun getCharacterPage(pageIndex: Int): GetCharacterPageResponse? {
        val request = NetworkLayer.apiClient.getCharactersPage(pageIndex)

        if (request.failed || !request.isSuccessful) {
            return null
        }

        return request.body
    }

}