package ayds.nene1.wikipedia.external

import ayds.nene1.wikipedia.external.wikidb.MovieDescriptionResponse

interface ExternalService {
    fun getMovieDescription(movieTitle: String, movieYear: String): MovieDescriptionResponse
}