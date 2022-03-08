interface GestorDeLibrosIUT {
    fun pedirID(): String
    fun existeLibro(existe: Boolean)
    fun informacionLibro(libros:Map<String, Any>)
}