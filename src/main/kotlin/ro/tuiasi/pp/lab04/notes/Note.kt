package ro.tuiasi.pp.lab04.notes

import java.time.LocalDateTime

/**
 * Reprezintă o notiță salvată în sistem.
 *
 * @property id Identificatorul unic al notiței (UUID recomandat)
 * @property author Autorul notiței
 * @property createdAt Data și ora creării
 * @property content Conținutul textual al notiței (poate fi multiliniar)
 */
data class Note(
    val id: String,
    val author: String,
    val createdAt: LocalDateTime,
    val content: String
)
