package ayds.nene1.wikipedia.wikidb

import ayds.nene1.wikipedia.ExternalService
import retrofit2.Response

class WikiService(
    private val wikiAPI: WikipediaAPI,
    private val wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescriptionResolver
) : ExternalService {

    override fun getMovieDescription(movieTitle: String, movieYear: String): MovieDescriptionResponse {
        val callResponse = getWikiMovieDescriptionFromService(movieTitle, movieYear)
        return wikiMovieDescriptionResolver.getMovieDescriptionFromExternalData(movieTitle,  callResponse?.body())
    }

    private fun getWikiMovieDescriptionFromService(movieTitle: String, movieYear: String): Response<String>? {
        var callResponse: Response<String>? = null
        try {
            callResponse = wikiAPI.getTerm(movieTitle + " " + movieYear + Constants.FILM).execute()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return callResponse
    }
}