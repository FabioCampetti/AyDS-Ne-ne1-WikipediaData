package ayds.nene1.wikipedia.wikiSubmodule

import ayds.nene1.wikipedia.WikipediaService
import retrofit2.Response

internal class WikipediaServiceImpl(
    private val wikiAPI: WikipediaAPI,
    private val wikiResponseResolver: WikiResponseResolver
) : WikipediaService {

    override fun getWikipediaResponse(movieTitle: String, movieYear: String): WikipediaResponse {
        val callResponse = getWikiResponseFromService(movieTitle, movieYear)
        return wikiResponseResolver.getWikipediaResponseFromExternalData(movieTitle, callResponse?.body())
    }

    private fun getWikiResponseFromService(movieTitle: String, movieYear: String): Response<String>? {
        var callResponse: Response<String>? = null
        try {
            callResponse = wikiAPI.getTerm(movieTitle + " " + movieYear + Constants.FILM).execute()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return callResponse
    }
}