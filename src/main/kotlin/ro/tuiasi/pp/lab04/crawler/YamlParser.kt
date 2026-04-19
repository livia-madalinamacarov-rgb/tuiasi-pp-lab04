package ro.tuiasi.pp.lab04.crawler

/**
 * Parser pentru conținut YAML simplu.
 *
 * Parsează un șir YAML cu perechi simple `cheie: valoare` (fără structuri imbricate)
 * și returnează o mapă Kotlin.
 *
 * Exemplu de intrare:
 * ```yaml
 * titlu: Articol important
 * autor: Ion Ionescu
 * an: 2024
 * ```
 */
class YamlParser : ContentParser {

    /**
     * Parsează un șir YAML simplu și returnează o mapă cheie→valoare.
     *
     * @param content Șirul YAML de parsat (format `cheie: valoare` pe fiecare linie)
     * @return Mapa cu perechile cheie→valoare extrase
     */
    override fun parse(content: String): Map<String, Any> {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Împărțiți content în linii: content.lines()
        // 2. Filtrați liniile goale și comentariile (care încep cu '#')
        // 3. Pentru fiecare linie, împărțiți după primul ':' cu limit=2
        //    ex: "cheie: valoare complexă".split(":", limit = 2)
        // 4. Cheia = prima parte, trimmed și fără ghilimele
        // 5. Valoarea = a doua parte, trimmed și fără ghilimele
        // 6. Detectați tipul: Int dacă poate fi parsat ca număr, altfel String
        TODO("De implementat: parsare YAML simplu (cheie: valoare) pe linii")
    }
}
