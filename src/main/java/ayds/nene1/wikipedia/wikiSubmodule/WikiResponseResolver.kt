package ayds.nene1.wikipedia.wikiSubmodule

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

interface WikiResponseResolver {
    fun getWikipediaResponseFromExternalData(movieTitle: String, body: String?): WikipediaResponse
}

class WikiResponseResolverImpl:
    WikiResponseResolver {

    override fun getWikipediaResponseFromExternalData(movieTitle: String, body: String?): WikipediaResponse{
        val text =  body?.let{getMovieText(it)}?:""
        return if(text == "") EmptyWikipediaResponse else WikipediaResponse(movieTitle, text, Constants.PATH_LOGO_WIKIPEDIA)
    }

    private fun getMovieText(body: String): String {
        val resultIterator: Iterator<JsonElement> = createResultIterator(body)
        var result = ""
        if (resultIterator.hasNext()) result = createMovieText(resultIterator.next().asJsonObject)
        return result
    }

    private fun createResultIterator(body: String): Iterator<JsonElement> {
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