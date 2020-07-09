package ayds.nene1.wikipedia.wikidb

open class MovieDescriptionResponse(
    var title: String ="",
    var text: String = "",
    var path: String = ""
)

object EmptyMovieDescriptionResponse: MovieDescriptionResponse()