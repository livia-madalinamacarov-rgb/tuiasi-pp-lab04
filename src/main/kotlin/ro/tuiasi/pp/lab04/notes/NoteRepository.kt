package ro.tuiasi.pp.lab04.notes

/**
 * Interfață repository pentru operații CRUD pe notițe.
 *
 * Abstractizează mecanismul de persistare (fișier, bază de date, memorie),
 * respectând principiul inversiei dependențelor (DIP).
 */
interface NoteRepository {
    /** Salvează (creează sau actualizează) o notiță. */
    fun save(note: Note)

    /** Caută o notiță după ID. Returnează `null` dacă nu există. */
    fun findById(id: String): Note?

    /** Returnează toate notițele disponibile. */
    fun findAll(): List<Note>

    /** Șterge notița cu ID-ul dat. */
    fun delete(id: String)
}
