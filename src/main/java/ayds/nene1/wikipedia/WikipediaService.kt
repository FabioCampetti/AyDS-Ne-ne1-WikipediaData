package ayds.nene1.wikipedia

import ayds.nene1.wikipedia.wikiSubmodule.*

interface WikipediaService {
    fun getCard(movieTitle: String, movieYear: String): Card

    companion object{
        fun getInstance(wikipediaAPI: WikipediaAPI,
                        wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescriptionResolver)
                        : WikipediaService =  WikipediaServiceImpl(wikipediaAPI, wikiMovieDescriptionResolver)
    }
}