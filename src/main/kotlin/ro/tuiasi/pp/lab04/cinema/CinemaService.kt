package ro.tuiasi.pp.lab04.cinema

/**
 * Serviciu cu logica business a aplicației cinema.
 *
 * Respectă principiul responsabilității unice (SRP): conține doar
 * logica de rezervare, anulare și interogare, delegând persistența
 * către [CinemaRepository].
 *
 * @property repo Repository-ul folosit pentru persistarea datelor
 */
class CinemaService(private val repo: CinemaRepository) {

    /**
     * Rezervă un bilet pentru [movie] la scaunul [seat].
     *
     * @param movie Filmul pentru care se face rezervarea
     * @param seat Scaunul dorit
     * @param price Prețul biletului
     * @return Biletul creat și salvat
     * @throws IllegalStateException dacă scaunul nu este disponibil
     */
    fun bookTicket(movie: Movie, seat: Seat, price: Double): Ticket {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Verificați că seat.isAvailable == true
        //    Dacă nu: throw IllegalStateException("Scaunul ${seat.row}/${seat.number} nu este disponibil")
        // 2. Marcați scaunul ca indisponibil: repo.updateSeat(seat.copy(isAvailable = false))
        // 3. Creați biletul: val bilet = Ticket(movie, seat.copy(isAvailable = false), price)
        // 4. Salvați biletul: repo.saveTicket(bilet)
        // 5. Returnați biletul
        TODO("De implementat: verifică disponibilitate, marchează scaunul și creează biletul")
    }

    /**
     * Anulează un bilet și eliberează scaunul.
     *
     * @param ticket Biletul de anulat
     */
    fun cancelTicket(ticket: Ticket) {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Ștergeți biletul: repo.deleteTicket(ticket)
        // 2. Eliberați scaunul: repo.updateSeat(ticket.seat.copy(isAvailable = true))
        TODO("De implementat: șterge biletul și marchează scaunul ca disponibil")
    }

    /**
     * Returnează lista scaunelor disponibile pentru [movie].
     *
     * @param movie Filmul pentru care se caută scaune
     * @return Lista scaunelor cu `isAvailable = true`
     */
    fun availableSeats(movie: Movie): List<Seat> {
        // TODO("De implementat")
        // Obțineți toate scaunele și filtrați doar pe cele disponibile
        TODO("De implementat: returnează scaunele disponibile (isAvailable == true)")
    }
}
