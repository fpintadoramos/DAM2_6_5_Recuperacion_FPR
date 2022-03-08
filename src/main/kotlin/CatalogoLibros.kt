abstract class CatalogoLibros{
    abstract fun infoLibro(idLibro:String):Map<String, Any>
    abstract fun existeLibro(idLibro:String):Boolean
}