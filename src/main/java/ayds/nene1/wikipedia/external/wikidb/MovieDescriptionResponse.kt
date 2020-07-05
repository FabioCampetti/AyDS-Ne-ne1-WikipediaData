package ayds.nene1.wikipedia.external.wikidb


open class MovieDescriptionResponse(
    var title: String ="",
    var text: String = "",
    var path: String = "",
    var source: String = ""
)

object EmptyMovieDescriptionResponse: MovieDescriptionResponse()