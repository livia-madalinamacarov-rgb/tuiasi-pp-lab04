package ro.tuiasi.pp.lab04.crawler

/**
 * Parser pentru conținut XML.
 *
 * Parsează un șir XML simplu cu elemente de nivel 1 sub rădăcină
 * și returnează o mapă cu valorile text ale elementelor.
 *
 * Exemplu de intrare:
 * ```xml
 * <date>
 *   <titlu>Articol</titlu>
 *   <autor>Ion</autor>
 * </date>
 * ```
 */
class XmlParser : ContentParser {

    /**
     * Parsează un șir XML și returnează o mapă element→text.
     *
     * @param content Șirul XML de parsat
     * @return Mapa cu perechile numeElement→textConținut
     */
    override fun parse(content: String): Map<String, Any> {
        // TODO("De implementat")
        // Pași de urmat cu jsoup (parser XML):
        // 1. val doc = Jsoup.parse(content, "", org.jsoup.parser.Parser.xmlParser())
        // 2. Obțineți elementul rădăcină: doc.children().first() sau doc.body()
        // 3. Iterați prin copiii rădăcinii: element.children()
        // 4. Pentru fiecare copil, adăugați în mapă: copil.tagName() → copil.text()
        TODO("De implementat: parsare XML cu jsoup, returnează mapă tagName→text")
    }
}
