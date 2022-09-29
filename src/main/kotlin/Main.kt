fun main() {
    var tierra:Tierra = Factoria.crearTierra()
    for(i in tierra.parrilla.indices){
        for(j in tierra.parrilla[i].indices) {
            print("${tierra.parrilla[i][j]} ")
        }
        println()
    }
}