class Tierra {
    var c:Cuadrante = Cuadrante()
    var parrilla = Array(3) { Array<Cuadrante>(3) {c} }

    override fun toString(): String {
        return "Tierra(parrilla=${parrilla.contentToString()})"
    }
}