package com.example.nytimeapp.network

data class Resource<out T>(val status: NStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
            Resource(status = NStatus.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = NStatus.ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = NStatus.LOADING, data = data, message = null)
    }
}
