# Lab 04 — Kotlin SOLID (OkHttp + jsoup)

## Obiective

- Aplicarea principiilor SOLID în Kotlin
- Principiul inversiei dependențelor (DIP) — injecție de dependențe
- Principiul responsabilității unice (SRP) — separarea claselor după rol
- Principiul substituției Liskov (LSP) — interfețe interșanjabile
- Design orientat pe interfețe și testabilitate

---

## Tema 1 — Web crawler cu parsere (Principiul inversiei dependențelor)

### Cerință

Extindeți crawler-ul din Lab 03, aplicând principiul DIP: crawler-ul primește parserul prin injecție de dependențe, nu îl instanțiază intern.

### Interfață de implementat

```kotlin
interface ContentParser {
    fun parse(content: String): Map<String, Any>
}
```

### Implementări de realizat

| Clasă | Comportament |
|-------|-------------|
| `JsonParser` | Parsează un șir JSON și returnează o mapă cheie→valoare |
| `XmlParser` | Parsează un șir XML și returnează o mapă cheie→valoare |
| `YamlParser` | Parsează un șir YAML simplu (format `cheie: valoare`) |

### Crawler cu injecție

```kotlin
class Crawler(private val parser: ContentParser) {
    fun fetch(url: String): Map<String, Any>
}
```

`fetch` descarcă conținutul de la URL și îl parsează cu `parser.parse()`.

---

## Tema 2 — Aplicație cinema (SOLID)

### Cerință

Implementați un sistem de rezervare bilete cinema respectând principiile SOLID.

### Clase și interfețe de implementat

**Modele de date:**
```kotlin
data class Movie(val id: Int, val title: String, val duration: Int)
data class Seat(val row: Int, val number: Int, val isAvailable: Boolean)
data class Ticket(val movie: Movie, val seat: Seat, val price: Double)
```

**Interfață repository:**
```kotlin
interface CinemaRepository {
    fun addMovie(movie: Movie)
    fun findMovie(id: Int): Movie?
    fun addSeat(seat: Seat)
    fun findSeat(row: Int, number: Int): Seat?
    fun updateSeat(seat: Seat)
    fun saveTicket(ticket: Ticket)
    fun findTicket(movie: Movie, seat: Seat): Ticket?
    fun deleteTicket(ticket: Ticket)
    fun allSeats(movie: Movie): List<Seat>
}
```

**Implementare in-memory:**
```kotlin
class InMemoryCinemaRepository : CinemaRepository
```

**Serviciu business:**
```kotlin
class CinemaService(private val repo: CinemaRepository) {
    fun bookTicket(movie: Movie, seat: Seat, price: Double): Ticket
    fun cancelTicket(ticket: Ticket)
    fun availableSeats(movie: Movie): List<Seat>
}
```

### Reguli business

- `bookTicket`: verifică că scaunul este disponibil; dacă nu, aruncă `IllegalStateException`
- `cancelTicket`: marchează scaunul ca disponibil și șterge biletul
- `availableSeats`: returnează doar scaunele cu `isAvailable = true`

---

## Tema 3 — Aplicație notițe CLI (SOLID)

### Cerință

Implementați o aplicație de gestionare a notițelor cu persistență pe disk, respectând SOLID.

### Clase de implementat

**Model:**
```kotlin
data class Note(
    val id: String,
    val author: String,
    val createdAt: java.time.LocalDateTime,
    val content: String
)
```

**Interfață repository:**
```kotlin
interface NoteRepository {
    fun save(note: Note)
    fun findById(id: String): Note?
    fun findAll(): List<Note>
    fun delete(id: String)
}
```

**Implementare pe fișier:**
```kotlin
class FileNoteRepository(private val dir: java.nio.file.Path) : NoteRepository
```

Fiecare notiță este stocată ca fișier text `{id}.txt` cu formatul:
```
AUTHOR: <autor>
CREATED_AT: <data ISO>
CONTENT:
<conținut multiliniar>
```

**Manager business:**
```kotlin
class NoteManager(private val repo: NoteRepository) {
    fun createNote(author: String, content: String): Note
    fun loadNote(id: String): Note
    fun listNotes(): List<Note>
    fun deleteNote(id: String)
}
```

**Meniu CLI:**
```kotlin
class CliMenu(private val manager: NoteManager) {
    fun run()
}
```

Meniul afișează opțiunile: (1) Listare, (2) Încărcare, (3) Creare, (4) Ștergere, (0) Ieșire.

---

## Criterii de evaluare

| Criteriu | Puncte |
|---------|--------|
| Tema 1 — ContentParser + Crawler DIP | 25p |
| Tema 2 — CinemaService SOLID | 40p |
| Tema 3 — NoteManager + FileRepository | 35p |

**Total: 100 puncte**

---

## Rulare teste

```bash
gradle test
```
