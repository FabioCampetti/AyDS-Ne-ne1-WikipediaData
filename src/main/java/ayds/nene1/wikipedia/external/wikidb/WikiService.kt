package ayds.nene1.wikipedia.external.wikidb
import ayds.nene.movieinfo.home.model.entities.OmdbMovie
import ayds.nene.movieinfo.moredetails.model.entities.MovieDescription
import ayds.nene1.wikipedia.external.ExternalService
import retrofit2.Response

internal class WikiService(
    private val wikiAPI: WikipediaAPI,
    private val wikiMovieDescriptionResolver: WikiResponseToWikiMovieDescriptionResolver
) : ExternalService {

    override fun getMovieDescription(movie: OmdbMovie): MovieDescription {
        val callResponse = getWikiMovieDescriptionFromService(movie)
        return wikiMovieDescriptionResolver.getMovieDescriptionFromExternalData(movie, callResponse?.body())
    }

    private fun getWikiMovieDescriptionFromService(movie: OmdbMovie): Response<String>? {
        var callResponse: Response<String>? = null
        try {
            callResponse = wikiAPI.getTerm(movie.title + " " + movie.year + Constants.FILM).execute()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return callResponse
    }
}