package ayds.nene1.wikipedia.wikiSubmodule

open class Card(
    var title: String ="",
    var text: String = "",
    var path: String = ""
)

object EmptyCard: Card()