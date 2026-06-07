package org.example
import java.io.File
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Utilizator(
    val nume: String
)

class Notita(
    val id: String,
    val autor: String,
    val data: String,
    val ora: String,
    val continut: String
)

interface RepositoryNotite {      //  defineste operatiile de baza

    fun salveaza(notita: Notita)
    fun gasesteToate(): List<Notita> // returneaza toate notitele
    fun gasesteDupaId(id: String): Notita?
    fun sterge(id: String): Boolean
}

class ManagerNotite : RepositoryNotite {

    private val folder = File("notes")// obiect File care reprezinta folderul "notes"

    init {    // se executa automat la creearea obiectului
        if (!folder.exists()) {
            folder.mkdir()
        }
    }

    override fun salveaza(notita: Notita) {// salvare notita in fisier

        val fisier = File(folder, notita.id + ".txt")// creare fisier in folderul notes(numele fisierului este id ul notitei+txt)

        fisier.writeText( //scrie continutul in fisier
            notita.id + "\n" +
                    notita.autor + "\n" +
                    notita.data + "\n" +
                    notita.ora + "\n" +
                    notita.continut
        )
    }

    override fun gasesteToate(): List<Notita> {     //  citeste toate notitele salvate in folder

        val notite = mutableListOf<Notita>()    // lista goala in care se adauga notitele gasite
        val fisiere = folder.listFiles()    //  toate fisierele din folderul "notes"
        if (fisiere == null) {
            return notite
        }
        for (fisier in fisiere) {  // parcurgere fiecare fisier din folder
            val notita = fisierLaNotita(fisier)   //fisierul intr un obiect Note
            if (notita != null) {   // daca fisierul a putut fi transformat in notita
                notite.add(notita)
            }
        }
        return notite
    }

    override fun gasesteDupaId(id: String): Notita? {

        // Numele fisierului trebuie sa fie id-ul notitei + ".txt"
        val fisier = File(folder, id + ".txt")         // Cream un obiect File care reprezinta fisierul notitei
        if (!fisier.exists()) {          // Verificam daca fisierul exista
            return null             // Daca fisierul nu exista, inseamna ca notita nu exist
        }
        return fisierLaNotita(fisier)
    }

    override fun sterge(id: String): Boolean {

        val fisier = File(folder, id + ".txt")  // obiectul File pt notita care trebuie stearsa
        if (fisier.exists()) {
            return fisier.delete()
        }
        return false
    }

    private fun fisierLaNotita(fisier: File): Notita? {  //  transforma un fisier text intr un obiect Note

        val linii = fisier.readLines() // citire toate liniile din fisier
        if (linii.size < 5) {     // minim 5
            return null
        }
        val id = linii[0]
        val autor = linii[1]
        val data = linii[2]
        val ora = linii[3]
        var continut = ""
        for (i in 4 until linii.size) { //se parcurg liniile incepand de la 4(acolo incepe continutul notitei)
            continut += linii[i] + "\n"    // se adauga fiecare linie la continut
        }
        return Notita(id, autor, data, ora, continut)

    }

    private fun genereazaUrmatorulId(): String {
        val notite = gasesteToate() //toate notitele existente
        if (notite.isEmpty()) {
            return "1"
        }
        val maxId = notite.maxOf { it.id.toLong() } //cel mare mare id existent
        return (maxId + 1).toString()//la id ul max adaug 1 pt urmatorul id
    }

    fun creeazaNotita(utilizator: Utilizator, continut: String) {

        val id = genereazaUrmatorulId()
        val data = LocalDate.now().toString() //data curenta
        val ora = LocalTime.now().format( //ora curenta
            DateTimeFormatter.ofPattern("HH:mm:ss")
        )
        val notita = Notita(
            id,
            utilizator.nume,
            data,
            ora,
            continut
        ) //creeare obiect notita cu toate datele
        salveaza(notita)
        println("Notita salvata cu id: $id")
    }
}
fun main() {

    val utilizator = Utilizator("Livia")
    val manager = ManagerNotite()

    while (true) {

        println("\n Meniu")
        println("1 - Lista notite")
        println("2 - Incarca notita")
        println("3 - Creeaza notita")
        println("4 - Sterge notita")
        println("0 - Iesire")

        print("Alege optiunea: ")
        val optiune = readLine()

        when (optiune) {

            "1" -> {
                val notite = manager.gasesteToate() //toate notitele salvate

                if (notite.isEmpty()) {
                    println("Nu exista notite.")
                } else {
                    println("\n=== TOATE NOTITELE ===")
                    for (notita in notite) {  //parcurgere fiecare notita si afisarea datelor ei
                        println("ID: ${notita.id}")
                        println("Autor: ${notita.autor}")
                        println("Data: ${notita.data}")
                        println("Ora: ${notita.ora}")
                        println("Continut: ${notita.continut}")
                        println("--------------------")
                    }
                }
            }

            "2" -> {
                print("ID notita: ")
                val id = readLine()?.trim() //citire id si eliminare spatii

                if (id.isNullOrEmpty()) {
                    println("ID invalid.")
                } else {
                    val notita = manager.gasesteDupaId(id) //cautare notita dupa id

                    if (notita == null) {
                        println("Notita nu exista.")
                    } else {
                        println("\n=== NOTITA GASITA ===")
                        println("ID: ${notita.id}")
                        println("Autor: ${notita.autor}")
                        println("Data: ${notita.data}")
                        println("Ora: ${notita.ora}")
                        println("Continut: ${notita.continut}")
                    }
                }
            }
            "3" -> {
                print("Introdu continutul notitei: ")
                val continut = readLine()?.trim() //citire continut notita si eliminare spatii

                if (continut.isNullOrEmpty()) {
                    println("Continut invalid.")
                } else {
                    manager.creeazaNotita(utilizator, continut)
                }
            }

            "4" -> {
                print("ID notita de sters: ")
                val id = readLine()?.trim()

                if (id.isNullOrEmpty()) {
                    println("ID invalid.")
                } else {
                    val deleted = manager.sterge(id) //stergere notita daca exista
                    if (deleted) {
                        println("Notita stearsa.")
                    } else {
                        println("Notita nu exista.")
                    }
                }
            }
            "0" -> {
                println("Program inchis.")
                return
            }
            else -> {
                println("Optiune invalida.")
            }
        }
    }
}