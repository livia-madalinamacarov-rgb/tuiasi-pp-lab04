package ro.tuiasi.pp.lab04.crawler

/**
 * Parser pentru conținut JSON.
 *
 * Parsează un șir JSON simplu de forma `{"cheie": "valoare", ...}`
 * și returnează o mapă Kotlin.
 *
 * Implementare minimală fără biblioteci externe — parsează doar obiecte
 * JSON plate (fără obiecte sau array-uri imbricate).
 */
class JsonParser : ContentParser {

    /**
     * Parsează un șir JSON și returnează o mapă cheie→valoare.
     *
     * Exemplu de intrare:
     * ```json
     * {"titlu": "Articol", "autor": "Ion", "an": 2024}
     * ```
     *
     * @param content Șirul JSON de parsat
     * @return Mapa cu perechile cheie→valoare extrase
     */
    override fun parse(content: String): Map<String, Any> {
        // TODO("De implementat")
        // Pași de urmat (fără bibliotecă JSON externă):
        // 1. Eliminați spațiile de la început și sfârșit, și caracterele '{' și '}'
        // 2. Împărțiți în perechi cheie:valoare după virgulă: content.split(",")
        // 3. Pentru fiecare pereche, împărțiți după primul ':' și extrageți cheia și valoarea
        // 4. Eliminați ghilimelele din jurul cheilor și valorilor string
        // 5. Detectați tipul valorii: dacă poate fi parseată ca Int → Int, altfel String
        // Alternativ: puteți adăuga Gson/Jackson în pom.xml dacă doriți o soluție mai robustă
        TODO("De implementat: parsare JSON simplu (obiecte plate cheie:valoare)")
    }
}
