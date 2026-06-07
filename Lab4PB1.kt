
import org.jsoup.Jsoup // pt a lucra cu HTML/XML și să parsez textul tip document
import org.jsoup.parser.Parser as JsoupParser //parserul din jsoup pt xml


interface Parser {

    fun parse(text: String): Map<String, String>   //returneaza un Map(dictionar de forma cheie->valoare)
    //primește un text (string) ( JSON, XML sau YAML)
}
 class XmlParser : Parser {

     override fun parse(text: String): Map<String, String> {
         val doc = Jsoup.parse(text, "", JsoupParser.xmlParser()) // transformă textul XML într un document jsoup folosind parser XML
         val rezultat = mutableMapOf<String, String>() //map in care se salveaza rezultatul

         val root = doc.children().first()  //elementul radacina
         // doc.children() = toate nodurile de nivel superior

         if (root != null) {
             for (element in root.children()) {  //parcurgere copiii radacinii daca exista
                 rezultat[element.tagName()] = element.text()
                 // element.tagName() → ia numele tagului  ( pentru <to>Livia</to> → "to")
                 // element.text() → ia ce este între taguri(Livia)
             }
         }

         return rezultat
     }
 }
class JsonParser : Parser {   //  parsează JSON (doar îl returnează ca text)

    override fun parse(text: String): Map<String, String> {

        return mapOf(  //map cu 2 valori  type->JSON, content->textul primit
            "type" to "JSON",
            "content" to text
        )
    }
}

 //nu parsează real, doar returnează textul
class YamlParser : Parser {

    override fun parse(text: String): Map<String, String> {

        return mapOf(
            "type" to "YAML",  //tipul continutului
            "content" to text  //continutul
        )
    }
}

class Crawler(private val url: String) {  // face request ul și alege parserul

    fun getResource(): String {    //descarca textul de la URL

        return Jsoup.connect(url)    //face conexiunea la URL
            .ignoreContentType(true) // permite citirea JSON/XML/YAML (nu doar HTML)
            .execute()  //executa
            .body()
    }

    fun processContent(contentType: String): Map<String, String> { //primeste tipul continutului

        val parser: Parser  //declar parser

        if (contentType.lowercase() == "json") {  //aleg parserul in functie de tip
            parser = JsonParser()
        }
        else if (contentType.lowercase() == "xml") {
            parser = XmlParser()
        }
        else if (contentType.lowercase() == "yaml") {
            parser = YamlParser()
        }
        else {
            throw IllegalArgumentException("Tip de continut necunoscut")
        }
        val text = getResource()  //se ia continutul de la url
        return parser.parse(text)   //textul este trimis la parser
    }
}

fun main() {

    println("JSON:")
    // creare crawler pentru JSON
    val jsonCrawler = Crawler("https://jsonplaceholder.typicode.com/todos/1")
    val jsonResult = jsonCrawler.processContent("json")
    // afisare (cheie->valoare)
    for ((key, value) in jsonResult) {
        println("$key -> $value")
    }
    println()

    println("XML:")
    // crawler pentru XML
    val xmlCrawler = Crawler("https://www.w3schools.com/xml/note.xml")
    val xmlResult = xmlCrawler.processContent("xml")

    for ((key, value) in xmlResult) {
        println("$key -> $value")
    }

    println()
    // crawler pentru YML
    println("YAML:")
    val yamlCrawler = Crawler("https://raw.githubusercontent.com/kubernetes/website/main/content/en/examples/pods/simple-pod.yaml")
    val yamlResult = yamlCrawler.processContent("yaml")

    for ((key, value) in yamlResult) {
        println("$key -> $value")
    }
}





