package tech.danielwaiguru.data.helpers

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import tech.danielwaiguru.data.helpers.Constants.EXISTING_SEARCH_ID
import tech.danielwaiguru.data.helpers.Constants.NON_EXISTING_SEARCH_ID
import tech.danielwaiguru.data.helpers.Constants.POPULAR_MOVIES_PATH
import java.net.HttpURLConnection

class MovieApiDispatcher: Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            POPULAR_MOVIES_PATH -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJsonResponse("json/popular_movies.json"))
            }
            "movie/$EXISTING_SEARCH_ID" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJsonResponse("json/movie_details.json"))
            }
            "movie/$NON_EXISTING_SEARCH_ID" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
                    .setBody(getJsonResponse("json/not_found.json"))
            }
            else -> throw IllegalAccessException("Unknown Request path ${request.path.toString()}")
        }
    }
}