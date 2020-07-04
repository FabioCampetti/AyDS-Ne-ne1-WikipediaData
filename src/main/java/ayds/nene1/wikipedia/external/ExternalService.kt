package ayds.nene1.wikipedia.external

import ayds.nene.movieinfo.home.model.entities.OmdbMovie
import ayds.nene.movieinfo.moredetails.model.entities.MovieDescription

interface ExternalService {
    fun getMovieDescription(movie: OmdbMovie): MovieDescription
}