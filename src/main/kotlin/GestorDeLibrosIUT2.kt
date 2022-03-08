class GestorDeLibrosIUT2: GestorDeLibrosIUT {
    override fun pedirID(): String {
        print("Insira o código do livro \n")
        var id: String = readln()

        return id
    }

    override fun existeLibro(existe: Boolean) {
        if(existe){
            print("O livro existe \n")
        }else{
            print("O livro não existe \n")
        }
    }

    override fun informacionLibro(libros: Map<String, Any>) {
        if(libros.isNotEmpty()){
            println("A informação sobre é a seguinte\n$libros")
        }else{
            println("Nenhuma informação encontrada sobre o livro")
        }
    }
}