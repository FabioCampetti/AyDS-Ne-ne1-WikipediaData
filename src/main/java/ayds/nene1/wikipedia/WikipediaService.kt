package ayds.nene1.wikipedia

import ayds.nene1.wikipedia.wikiSubmodule.MovieDescriptionResponse

interface WikipediaService {
    fun getMovieDescription(movieTitle: String, movieYear: String): MovieDescriptionResponse
}