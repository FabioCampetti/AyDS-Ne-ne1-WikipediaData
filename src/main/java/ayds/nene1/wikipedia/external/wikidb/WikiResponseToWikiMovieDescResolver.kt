package ayds.nene1.wikipedia.external.wikidb

import ayds.nene.movieinfo.home.model.entities.OmdbMovie
import ayds.nene.movieinfo.moredetails.model.entities.EmptyMovieDescription
import ayds.nene.movieinfo.moredetails.model.entities.MovieDescription
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

internal interface WikiResponseToWikiMovieDescriptionResolver {
    fun getMovieDescriptionFromExternalData(movie: OmdbMovie, body: String?): MovieDescription
}


class WikiResponseToWikiMovieDescriptionResolverImpl:
    WikiResponseToWikiMovieDescriptionResolver {

    override fun getMovieDescriptionFromExternalData(movie: OmdbMovie, body: String?): MovieDescription{
        val text = getMovieText(body)
        return if(text == "") EmptyMovieDescription else MovieDescription(movie,text,Constants.PATH_LOGO_WIKIPEDIA)
    }

    private fun getMovieText(body: String?): String {
        val resultIterator: Iterator<JsonElement> = createResultIterator(body)
        var result = ""
        if (resultIterator.hasNext()) result = createMovieText(resultIterator.next().asJsonObject)
        return result
    }

    private fun createResultIterator(body: String?): Iterator<JsonElement> {
        val result: Iterator<JsonElement>
        val gson = Gson()
        val jobj = gson.fromJson(body, JsonObject::class.java)
        val query = jobj[Constants.QUERY].asJsonObject
        result = query[Constants.SEARCH].asJsonArray.iterator()
        return result
    }

    private fun createMovieText(aJsonObject: JsonObject): String {
        val extract = aJsonObject[Constants.SNIPPET]
        val pageId = aJsonObject[Constants.PAGE_ID].asString
        var result = ""
        if (extract != null) {
            result = extract.asString.replace("\\n", "\n") + "..."
            result += "${Constants.PATH_WIKIPEDIA}$pageId${Constants.VIEW_ARTICLE}".trimIndent()
        }
        return result
    }
}