package ayds.nene1.wikipedia

import ayds.nene1.wikipedia.wikidb.MovieDescriptionResponse
import ayds.nene1.wikipedia.wikidb.WikiResponseToWikiMovieDescriptionResolver
import ayds.nene1.wikipedia.wikidb.WikipediaAPI
import ayds.nene1.wikipedia.wikidb.WikipediaServiceImpl

interface WikipediaService {
    fun getMovieDescription(movieTitle: String, movieYear: String): MovieDescriptionResponse

    companion object{
        fun getInstance(wikipediaAPI: WikipediaAPI,
                        wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescriptionResolver)
                        : WikipediaService =  WikipediaServiceImpl(wikipediaAPI, wikiMovieDescriptionResolver)
    }
}