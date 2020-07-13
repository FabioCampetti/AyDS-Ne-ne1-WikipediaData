package ayds.nene1.wikipedia.wikiSubmodule

open class WikipediaResponse(
    var title: String ="",
    var text: String = "",
    var path: String = ""
)

object EmptyWikipediaResponse: WikipediaResponse()