package tech.danielwaiguru.domain.common

sealed class ResultWrapper<out T> {
    data class Success<T>(val data: T): ResultWrapper<T>()
    data class Error<T>(val errorMessage: String?, val exception: Throwable): ResultWrapper<T>()
    object Loading: ResultWrapper<Nothing>()
}
