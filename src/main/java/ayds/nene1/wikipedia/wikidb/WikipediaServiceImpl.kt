package ayds.nene1.wikipedia.wikidb

import ayds.nene1.wikipedia.WikipediaService
import retrofit2.Response

class WikipediaServiceImpl(
    private val wikiAPI: WikipediaAPI,
    private val wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescriptionResolver
) : WikipediaService {

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