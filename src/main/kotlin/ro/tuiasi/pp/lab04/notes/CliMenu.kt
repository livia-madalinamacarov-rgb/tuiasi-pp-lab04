package ro.tuiasi.pp.lab04.notes

/**
 * Meniu CLI interactiv pentru gestionarea notițelor.
 *
 * Afișează un meniu text și procesează comenzile utilizatorului,
 * delegând operațiile business către [NoteManager].
 *
 * @property manager Manager-ul cu logica business
 */
class CliMenu(private val manager: NoteManager) {

    /**
     * Pornește bucla principală a meniului CLI.
     *
     * Meniu disponibil:
     * - 1: Listare notițe
     * - 2: Încărcare notiță după ID
     * - 3: Creare notiță nouă
     * - 4: Ștergere notiță
     * - 0: Ieșire
     */
    fun run() {
        // TODO("De implementat")
        // Pași de urmat:
        // 1. Creați un bucla while(true)
        // 2. Afișați meniul:
        //    println("\n=== Manager Notițe ===")
        //    println("1. Listare notițe")
        //    println("2. Încărcare notiță")
        //    println("3. Creare notiță")
        //    println("4. Ștergere notiță")
        //    println("0. Ieșire")
        //    print("Alegeți opțiunea: ")
        // 3. Citiți opțiunea: readLine()?.trim()
        // 4. Pe baza opțiunii, apelați metoda corespunzătoare din manager
        // 5. La opțiunea "0", ieșiți din buclă
        // 6. Tratați excepțiile și afișați mesaje de eroare prietenoase
        TODO("De implementat: buclă interactivă cu citire și procesare comenzi")
    }

    private fun listeazaNotite() {
        // TODO("De implementat")
        // Apelați manager.listNotes() și afișați ID-ul, autorul și data fiecărei notițe
        TODO("De implementat: afișează lista notițelor")
    }

    private fun incarcaNota() {
        // TODO("De implementat")
        // Citiți ID-ul de la consolă, apelați manager.loadNote(id) și afișați conținutul
        TODO("De implementat: citește ID și afișează conținutul notiței")
    }

    private fun creeazaNota() {
        // TODO("De implementat")
        // Citiți autorul și conținutul de la consolă, apelați manager.createNote(...)
        // Afișați ID-ul notiței create
        TODO("De implementat: citește autor și conținut, creează și confirmă notița")
    }

    private fun stergeNota() {
        // TODO("De implementat")
        // Citiți ID-ul de la consolă, apelați manager.deleteNote(id)
        // Confirmați ștergerea
        TODO("De implementat: citește ID și șterge notița, afișează confirmare")
    }
}
