import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var modo: GestorDeLibrosIUT
    //Random para elegir un modo de pedir datos
    var ran = (1..2).random()
    if(ran ==1){
        modo = GestorDeLibrosIUT1()
    }else{
        modo = GestorDeLibrosIUT2()
    }



    //Con XML
    var catXML= "Catalog.xml"
    var catalogoXML = CatalogoLibrosXML(catXML)
    val gestorDeLibrosXML = gestionLibros(catalogoXML, modo)
    gestorDeLibrosXML.preguntarPorUnLibro()
    gestorDeLibrosXML.mostrarInfoDeUnLibro()

    //Con JSON
    var jsonLibros = """[{"id":"bk101","autor":"Pedris1","title":"Libro de eduardo 1","genre":"Ficcion 1","price":29.41,"publish_date":"Oct 1, 2000 12:00:00 AM","description":"Descripción del libro 1"}
        |,{"id":"bk102","autor":"Pedris2","title":"Libro de eduardo 2","genre":"Ficcion 2","price":29.42,"publish_date":"Oct 2, 2000 12:00:00 AM","description":"Descripción del libro 2"}
        |,{"id":"bk103","autor":"Pedris3","title":"Libro de eduardo 3","genre":"Ficcion 3","price":29.43,"publish_date":"Oct 3, 2000 12:00:00 AM","description":"Descripción del libro 3"}
        |,{"id":"bk104","autor":"Pedris4","title":"Libro de eduardo 4","genre":"Ficcion 4","price":29.44,"publish_date":"Oct 4, 2000 12:00:00 AM","description":"Descripción del libro 4"}
        |,{"id":"bk105","autor":"Pedris5","title":"Libro de eduardo 5","genre":"Ficcion 5","price":29.45,"publish_date":"Oct 5, 2000 12:00:00 AM","description":"Descripción del libro 5"}
        |]""".trimMargin()

    var catalogoJSON = CatalogoLibrosJSON(jsonLibros)
    val gestorDeLibrosJSON = gestionLibros(catalogoJSON, modo)
    gestorDeLibrosJSON.preguntarPorUnLibro()
    gestorDeLibrosJSON.mostrarInfoDeUnLibro()

}

class gestionLibros(catalogo:CatalogoLibros, modo:GestorDeLibrosIUT)
{
    var cat = catalogo
    var m = modo

    fun preguntarPorUnLibro() {
        var idLibro = m.pedirID()
        m.existeLibro(cat.existeLibro(idLibro))
    }

    fun mostrarInfoDeUnLibro()
    {
        var idLibro = m.pedirID()
        var infoLibro = cat.infoLibro(idLibro)
        m.informacionLibro(infoLibro)
    }

}