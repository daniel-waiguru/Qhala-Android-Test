package tech.danielwaiguru.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1

    )
}