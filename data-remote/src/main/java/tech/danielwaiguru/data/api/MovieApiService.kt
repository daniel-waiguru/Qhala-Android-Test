package tech.danielwaiguru.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import tech.danielwaiguru.data.models.response.MovieResponse

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "7d533c39f66d4a212a1b3c81273ec7d1",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MovieResponse
}