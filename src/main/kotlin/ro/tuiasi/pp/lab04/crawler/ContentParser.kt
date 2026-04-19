package ro.tuiasi.pp.lab04.crawler

/**
 * Interfață pentru parsarea conținutului web descărcat de crawler.
 *
 * Respectă principiul inversiei dependențelor (DIP): crawler-ul
 * depinde de această abstractizare, nu de implementările concrete.
 *
 * Implementări concrete: [JsonParser], [XmlParser], [YamlParser].
 */
interface ContentParser {
    /**
     * Parsează un șir de conținut și returnează o mapă de perechi cheie-valoare.
     *
     * @param content Conținutul brut de parsat (JSON, XML, YAML etc.)
     * @return Mapa cu datele extrase din conținut
     */
    fun parse(content: String): Map<String, Any>
}
