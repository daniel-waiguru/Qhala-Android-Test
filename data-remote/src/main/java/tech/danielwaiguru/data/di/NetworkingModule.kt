package tech.danielwaiguru.data.di

import android.os.Build
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.danielwaiguru.data.api.MovieApiService
import tech.danielwaiguru.data.common.Constants.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = when (Build.TYPE) {
                "release" -> HttpLoggingInterceptor.Level.NONE
                else -> HttpLoggingInterceptor.Level.BODY
            }
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService? {
        return retrofit.create(MovieApiService::class.java)
    }
}