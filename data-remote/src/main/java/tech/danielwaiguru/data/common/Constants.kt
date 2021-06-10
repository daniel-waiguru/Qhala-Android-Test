package tech.danielwaiguru.data.common

object Constants {
    init {
        System.loadLibrary("native-lib")
    }
    const val BASE_URL = "https://api.themoviedb.org/3/"
    external fun getApiKey(): String
}