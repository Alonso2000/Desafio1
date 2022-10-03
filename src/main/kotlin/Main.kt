fun main() {
    var tierra:Tierra = Factoria.crearTierra()
    var tet:Tet = Tet()
    Factoria.crearDron(tet)
    println(tet.drones)
    Factoria.crearCuadrante(tet, tierra)
    for(i in tierra.parrilla.indices){
        for(j in tierra.parrilla[i].indices) {
            print("${tierra.parrilla[i][j]} ")
        }
        println()
    }
    println(tet.drones)
}