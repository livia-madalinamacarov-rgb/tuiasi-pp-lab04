package ro.tuiasi.pp.lab04.cinema

/**
 * Interfață repository pentru gestionarea datelor aplicației cinema.
 *
 * Respectă principiul inversiei dependențelor (DIP) și principiul
 * segregării interfețelor (ISP).
 */
interface CinemaRepository {
    /** Adaugă un film nou în repository. */
    fun addMovie(movie: Movie)

    /** Caută un film după ID. Returnează `null` dacă nu există. */
    fun findMovie(id: Int): Movie?

    /** Adaugă un scaun nou în repository. */
    fun addSeat(seat: Seat)

    /** Caută un scaun după rând și număr. Returnează `null` dacă nu există. */
    fun findSeat(row: Int, number: Int): Seat?

    /** Actualizează datele unui scaun (ex: disponibilitate). */
    fun updateSeat(seat: Seat)

    /** Salvează un bilet nou. */
    fun saveTicket(ticket: Ticket)

    /** Caută biletul pentru un film și scaun specific. */
    fun findTicket(movie: Movie, seat: Seat): Ticket?

    /** Șterge un bilet din repository. */
    fun deleteTicket(ticket: Ticket)

    /** Returnează toate scaunele asociate unui film. */
    fun allSeats(movie: Movie): List<Seat>
}
