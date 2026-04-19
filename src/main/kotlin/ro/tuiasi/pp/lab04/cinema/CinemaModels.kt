package ro.tuiasi.pp.lab04.cinema

/**
 * Reprezintă un film disponibil la cinema.
 *
 * @property id Identificatorul unic al filmului
 * @property title Titlul filmului
 * @property duration Durata filmului în minute
 */
data class Movie(
    val id: Int,
    val title: String,
    val duration: Int
)

/**
 * Reprezintă un scaun din sala de cinema.
 *
 * @property row Numărul rândului (1-based)
 * @property number Numărul scaunului în rând (1-based)
 * @property isAvailable `true` dacă scaunul nu este rezervat
 */
data class Seat(
    val row: Int,
    val number: Int,
    val isAvailable: Boolean
)

/**
 * Reprezintă un bilet cumpărat pentru un film și un scaun specific.
 *
 * @property movie Filmul pentru care s-a cumpărat biletul
 * @property seat Scaunul rezervat
 * @property price Prețul biletului în lei
 */
data class Ticket(
    val movie: Movie,
    val seat: Seat,
    val price: Double
)
