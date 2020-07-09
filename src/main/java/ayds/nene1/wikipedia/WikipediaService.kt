package ayds.nene1.wikipedia

import ayds.nene1.wikipedia.wikidb.MovieDescriptionResponse

interface WikipediaService {
    fun getMovieDescription(movieTitle: String, movieYear: String): MovieDescriptionResponse
}