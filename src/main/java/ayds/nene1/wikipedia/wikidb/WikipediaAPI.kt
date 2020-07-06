package ayds.nene1.wikipedia.wikidb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaAPI {

    @GET("api.php?action=query&list=search&utf8=&format=json&srlimit=1")
    fun getTerm(@Query("srsearch") term: String?): Call<String>
}