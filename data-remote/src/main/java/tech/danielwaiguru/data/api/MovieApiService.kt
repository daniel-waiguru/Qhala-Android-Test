package tech.danielwaiguru.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.danielwaiguru.data.common.Constants.getApiKey
import tech.danielwaiguru.data.models.MovieDto
import tech.danielwaiguru.data.models.response.MovieResponse

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = getApiKey(),
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MovieResponse
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
            @Path("movie_id") mId: Int,
            @Query("api_key") apiKey: String = getApiKey(),
            @Query("language") language: String = "en-US",
    ): MovieDto
}