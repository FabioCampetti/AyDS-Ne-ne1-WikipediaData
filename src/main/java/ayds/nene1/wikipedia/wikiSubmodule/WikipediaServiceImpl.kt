package ayds.nene1.wikipedia.wikiSubmodule

import ayds.nene1.wikipedia.WikipediaService
import retrofit2.Response

internal class WikipediaServiceImpl(
    private val wikiAPI: WikipediaAPI,
    private val wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescResolver
) : WikipediaService {

    override fun getWikipediaResponse(movieTitle: String, movieYear: String): WikipediaResponse {
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