package ayds.nene1.wikipedia

import ayds.nene1.wikipedia.wikiSubmodule.*
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

interface WikipediaService {
    fun getCard(movieTitle: String, movieYear: String): Card

    companion object{
        private const val URL_WIKIPEDIA = "https://en.wikipedia.org/w/"

        private val retrofit = Retrofit.Builder()
                .baseUrl(URL_WIKIPEDIA)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

        fun getInstance(): WikipediaService =  WikipediaServiceImpl(
                retrofit.create(WikipediaAPI::class.java),
                WikiResponseToWikiMovieDescResolverImpl()
        )
    }
}