class GestorDeLibrosIUT1 : GestorDeLibrosIUT{
    override fun pedirID(): String {
        print("Introduce el id del libro \n")
        var id: String = readln()

        return id
    }

    override fun existeLibro(existe: Boolean) {
        if(existe){
            print("El libro existe \n")
        }else{
            print("El libro no existe \n")
        }
    }

    override fun informacionLibro(libros: Map<String, Any>) {
        if(libros.isNotEmpty()){
            println("La información sobre es la siguiente\n$libros")
        }else{
            println("No se encontró información sobre el libro")
        }
    }
}