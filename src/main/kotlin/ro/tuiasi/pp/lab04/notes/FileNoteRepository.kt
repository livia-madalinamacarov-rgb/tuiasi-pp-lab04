package ro.tuiasi.pp.lab04.notes

import java.nio.file.Path
import java.time.LocalDateTime

/**
 * Implementare [NoteRepository] cu persistare pe disk.
 *
 * Fiecare notiță este stocată ca un fișier text individual cu numele `{id}.txt`
 * în directorul specificat.
 *
 * Formatul fișierului:
 * ```
 * AUTHOR: <autor>
 * CREATED_AT: <data ISO-8601>
 * CONTENT:
 * <conținut multiliniar>
 * ```
 *
 * @property dir Directorul în care se salvează fișierele de notițe
 */
class FileNoteRepository(private val dir: Path) : NoteRepository {

    /**
     * Salvează notița în fișierul `{id}.txt` din [dir].
     *
     * Dacă directorul nu există, îl creează automat.
     */
    override fun save(note: Note) {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Creați directorul dacă nu există: dir.toFile().mkdirs()
        // 2. Determinați calea fișierului: dir.resolve("${note.id}.txt")
        // 3. Scrieți conținutul în formatul specificat:
        //    "AUTHOR: ${note.author}\n" +
        //    "CREATED_AT: ${note.createdAt}\n" +
        //    "CONTENT:\n" +
        //    "${note.content}"
        // 4. Folosiți Files.writeString(cale, continut) sau file.writeText(continut)
        TODO("De implementat: salvează notița ca fișier text {id}.txt în directorul dir")
    }

    /**
     * Încarcă notița cu [id] din fișierul `{id}.txt`.
     *
     * @return Notița deserializată, sau `null` dacă fișierul nu există
     */
    override fun findById(id: String): Note? {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Construiți calea: dir.resolve("$id.txt")
        // 2. Dacă fișierul nu există, returnați null
        // 3. Citiți conținutul fișierului
        // 4. Parsați liniile:
        //    - Linia 0: "AUTHOR: ..." → extrageți autorul
        //    - Linia 1: "CREATED_AT: ..." → LocalDateTime.parse(...)
        //    - Linia 2: "CONTENT:" → ignorați
        //    - Restul liniilor: conținutul notiței (joined cu "\n")
        // 5. Returnați Note(id, autor, data, continut)
        TODO("De implementat: citește și parsează fișierul {id}.txt, returnează Note sau null")
    }

    /**
     * Returnează toate notițele din [dir], citind toate fișierele `*.txt`.
     */
    override fun findAll(): List<Note> {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Listați fișierele din dir cu extensia .txt: dir.toFile().listFiles { f -> f.extension == "txt" }
        // 2. Pentru fiecare fișier, extrageți id-ul din numele fișierului (fără extensie)
        // 3. Apelați findById(id) și colectați rezultatele non-null
        TODO("De implementat: listează toate fișierele .txt și le parsează ca notițe")
    }

    /**
     * Șterge fișierul `{id}.txt` din [dir].
     */
    override fun delete(id: String) {
        // TODO("De implementat")
        // 1. Construiți calea: dir.resolve("$id.txt")
        // 2. Ștergeți fișierul: cale.toFile().delete()
        TODO("De implementat: șterge fișierul {id}.txt din directorul dir")
    }
}
