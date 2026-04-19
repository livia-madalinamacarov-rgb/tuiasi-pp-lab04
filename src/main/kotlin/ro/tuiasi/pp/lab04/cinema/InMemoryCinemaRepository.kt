package ro.tuiasi.pp.lab04.cinema

/**
 * Implementare in-memory a [CinemaRepository].
 *
 * Stochează filmele, scaunele și biletele în liste din memorie.
 * Utilă pentru teste și prototipuri.
 */
class InMemoryCinemaRepository : CinemaRepository {

    // Stocarea datelor în memorie
    private val filme = mutableListOf<Movie>()
    private val scaune = mutableListOf<Seat>()
    private val bilete = mutableListOf<Ticket>()

    override fun addMovie(movie: Movie) {
        // TODO("De implementat")
        // Adăugați filmul în lista `filme`
        TODO("De implementat: adaugă filmul în lista internă")
    }

    override fun findMovie(id: Int): Movie? {
        // TODO("De implementat")
        // Căutați în `filme` după movie.id
        TODO("De implementat: caută filmul după id în lista internă")
    }

    override fun addSeat(seat: Seat) {
        // TODO("De implementat")
        // Adăugați scaunul în lista `scaune`
        TODO("De implementat: adaugă scaunul în lista internă")
    }

    override fun findSeat(row: Int, number: Int): Seat? {
        // TODO("De implementat")
        // Căutați în `scaune` după row și number
        TODO("De implementat: caută scaunul după rând și număr")
    }

    override fun updateSeat(seat: Seat) {
        // TODO("De implementat")
        // Înlocuiți scaunul cu aceleași row și number cu noul seat
        // Indiciu: găsiți indexul cu indexOfFirst și înlocuiți cu set(index, seat)
        TODO("De implementat: înlocuiește scaunul cu aceleași coordonate în lista internă")
    }

    override fun saveTicket(ticket: Ticket) {
        // TODO("De implementat")
        // Adăugați biletul în lista `bilete`
        TODO("De implementat: adaugă biletul în lista internă")
    }

    override fun findTicket(movie: Movie, seat: Seat): Ticket? {
        // TODO("De implementat")
        // Căutați în `bilete` un bilet cu movie.id și seat (row, number) corespunzătoare
        TODO("De implementat: caută biletul după film și scaun")
    }

    override fun deleteTicket(ticket: Ticket) {
        // TODO("De implementat")
        // Eliminați biletul din lista `bilete`
        TODO("De implementat: șterge biletul din lista internă")
    }

    override fun allSeats(movie: Movie): List<Seat> {
        // TODO("De implementat")
        // Returnați toate scaunele din `scaune`
        // Notă: într-o implementare reală, scaunele ar fi asociate cu filmul;
        // pentru simplitate, returnați toate scaunele din repository
        TODO("De implementat: returnează toate scaunele")
    }
}
