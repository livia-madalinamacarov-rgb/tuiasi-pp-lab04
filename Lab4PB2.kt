
package org.example

interface PaymentMethod
{
    fun pay(suma: Double) : Boolean //incearca sa faca plata unei sume
}

class CashPayment
    (private var sumaDisponibila: Double) : PaymentMethod
{
    override fun pay(suma: Double): Boolean
    {
        // verific daca exista suficienti bani disponibili
        if(sumaDisponibila>= suma)
        {
            sumaDisponibila=sumaDisponibila-suma
            return true
        }
        // daca nu sunt suficienti bani plata nu se face
        return false
    }
}

class BankAccount(
    private var availableAmount: Double,
    private val cardNumber: String,
    private val expirationDate: String,
    private val cvvCode: Int,
    private val userName: String
)
{
    fun updateAmount(value: Double): Boolean
    {
        // daca exista suficienti bani
        if(availableAmount>= value)
        {
            // retrage suma din cont
            availableAmount=availableAmount-value
            return true
        }
        return false
    }

    fun getUserName(): String{
        return userName
    }
}

class CardPayment(
    private val bankAccount: BankAccount
): PaymentMethod
{
    override fun pay(suma: Double): Boolean
    {
        // retragere suma din contul bancar
        val rezultatPlata=bankAccount.updateAmount(suma)

        if(rezultatPlata==true)
        {
            return true
        }
        return false
    }
}

class Movie
    (
    private val titlu: String,
    private val pret: Double
)
{
    fun getTitlu(): String
    {
        return titlu
    }

    fun getPret():Double{
        return pret
    }
}

class Client(
    private val nume: String,
    private val email: String
)
{
    fun getNume(): String{
        return nume
    }
    fun getEmail(): String
    {
        return email
    }
}

class Seat
    (
    private val rand: Int,
    private val numar: Int,
    private var disponibil : Boolean = true // toate locurile sunt disponibile la inceput
)
{
    // rezerva locul daca acesta este disponibil
    fun rezerva(): Boolean{
        if(disponibil)
        {
            disponibil=false
            return true
        }
        return false
    }

    fun getRand(): Int{
        return rand
    }

    fun getNumar(): Int{
        return numar
    }
}

class Screening
    (
    private val film: Movie,
    private val ora : String
)
{
    fun getFilm(): Movie{
        return film
    }

    fun getOra(): String{
        return ora
    }
}

//  descrie un bilet cumparat
class Ticket
    (
    private val client: Client,
    private val screening: Screening,
    private val seat: Seat,
    private val pret: Double
)
{
    fun afiseazaBilet()
    {
        println("Bilet cinema")
        println("Client:  "+ client.getNume())
        println("Film: " + screening.getFilm().getTitlu())
        println("Ora: " + screening.getOra())
        println("Loc: rand " + seat.getRand() + " numar: " + seat.getNumar())
        println("Pret: " + pret)
    }
}

class Cinema
{

    fun cumparaBilet(client: Client, screening: Screening, seat: Seat, payment: PaymentMethod): Ticket
    {
        if(!seat.rezerva())
        {
            throw Exception("Locul nu este disponibil")
        }
        val pretBilet=screening.getFilm().getPret()

        if(!payment.pay(pretBilet))
        {
            throw Exception("Plata a esuat")
        }
        return Ticket(client,screening,seat,pretBilet)
    }
}

fun main()
{
    val film=Movie("Frozen", 30.0)

    val screening=Screening(film, "20:00")

    val client=Client("Livia","livia.29@gmail.com")
    val client2 = Client("Ana", "ana@gmail.com")
    val client3 = Client("Maria", "maria@gmail.com")

    val loc=Seat(6,5)
    val loc2 = Seat(6,6)
    val loc3 = Seat(6,7)
    val cont=BankAccount(200.0,"123466900","11/29", 132,"Livia Macarov")

    // aleg metoda de plata card
    val metodaPlata: PaymentMethod= CardPayment(cont)

    val cinema=Cinema()
    val bilet=cinema.cumparaBilet(client, screening,loc,metodaPlata)
    val bilet2 = cinema.cumparaBilet(client2, screening, loc2, metodaPlata)
    val bilet3 = cinema.cumparaBilet(client3, screening, loc3, metodaPlata)
    bilet.afiseazaBilet()
    println()
    bilet2.afiseazaBilet()
    println()
    bilet3.afiseazaBilet()
}