package ayds.nene1.wikipedia

import ayds.nene1.wikipedia.wikiSubmodule.MovieDescriptionResponse
import ayds.nene1.wikipedia.wikiSubmodule.WikiResponseToWikiMovieDescriptionResolver
import ayds.nene1.wikipedia.wikiSubmodule.WikipediaAPI
import ayds.nene1.wikipedia.wikiSubmodule.WikipediaServiceImpl

interface WikipediaService {
    fun getMovieDescription(movieTitle: String, movieYear: String): MovieDescriptionResponse

    companion object{
        fun getInstance(wikipediaAPI: WikipediaAPI,
                        wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescriptionResolver)
                        : WikipediaService =  WikipediaServiceImpl(wikipediaAPI, wikiMovieDescriptionResolver)
    }
}