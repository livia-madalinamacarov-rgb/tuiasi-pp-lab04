package ro.tuiasi.pp.lab04.notes

import java.time.LocalDateTime
import java.util.UUID

/**
 * Manager business pentru operații cu notițe.
 *
 * Conține logica aplicației și delegă persistarea către [NoteRepository].
 * Respectă principiul responsabilității unice (SRP).
 *
 * @property repo Repository-ul folosit pentru persistare
 */
class NoteManager(private val repo: NoteRepository) {

    /**
     * Creează o notiță nouă cu ID generat automat și data curentă.
     *
     * @param author Autorul notiței
     * @param content Conținutul notiței
     * @return Notița creată și salvată
     */
    fun createNote(author: String, content: String): Note {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Generați un ID unic: UUID.randomUUID().toString()
        // 2. Obțineți data curentă: LocalDateTime.now()
        // 3. Creați nota: Note(id, author, data, content)
        // 4. Salvați: repo.save(nota)
        // 5. Returnați nota
        TODO("De implementat: generează ID unic, creează și salvează nota")
    }

    /**
     * Încarcă o notiță după ID.
     *
     * @param id ID-ul notiței
     * @return Notița găsită
     * @throws NoSuchElementException dacă notița nu există
     */
    fun loadNote(id: String): Note {
        // TODO("De implementat")
        // Apelați repo.findById(id) și aruncați NoSuchElementException dacă returnează null
        // Mesaj sugestiv: "Notița cu id=$id nu a fost găsită"
        TODO("De implementat: caută nota în repository, aruncă excepție dacă nu există")
    }

    /**
     * Returnează lista tuturor notițelor, sortate descrescător după data creării.
     *
     * @return Lista notițelor sortate
     */
    fun listNotes(): List<Note> {
        // TODO("De implementat")
        // Apelați repo.findAll() și sortați descrescător după createdAt
        TODO("De implementat: returnează toate notițele sortate descrescător după dată")
    }

    /**
     * Șterge notița cu [id].
     *
     * @param id ID-ul notiței de șters
     */
    fun deleteNote(id: String) {
        // TODO("De implementat")
        // Apelați repo.delete(id)
        TODO("De implementat: șterge nota cu id-ul dat din repository")
    }
}
