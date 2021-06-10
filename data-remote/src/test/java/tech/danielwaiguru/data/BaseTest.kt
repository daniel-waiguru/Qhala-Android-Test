package tech.danielwaiguru.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.danielwaiguru.data.api.MovieApiService
import tech.danielwaiguru.data.helpers.MovieApiDispatcher
import java.util.concurrent.TimeUnit

open class BaseTest {
    private lateinit var mockWebServer: MockWebServer
    lateinit var apiService: MovieApiService
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var loggingInterceptor: HttpLoggingInterceptor
    @Before
    open fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MovieApiDispatcher()
        mockWebServer.start()
        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = provideOkHttpClient(loggingInterceptor)
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }
    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }
    private fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }
}