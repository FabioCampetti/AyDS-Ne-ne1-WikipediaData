package ayds.nene1.wikipedia.wikiSubmodule

open class MovieDescriptionResponse(
    var title: String ="",
    var text: String = "",
    var path: String = ""
)

object EmptyMovieDescriptionResponse: MovieDescriptionResponse()