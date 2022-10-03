import kotlin.random.Random

object Factoria {
    fun crearDron(tet:Tet){
        for(i in 0..100){
            var d: Dron = Dron.Builder().operativo(true).build()
            tet.drones.add(d)
        }
    }

    fun crearTierra():Tierra{
        var tierra:Tierra = Tierra()
        return tierra
    }

    fun crearCuadrante(tet:Tet, tierra:Tierra){
        for(i in tierra.parrilla.indices){
            for(j in tierra.parrilla[i].indices){
                var cuadrante:Cuadrante = Cuadrante(tet.drones[0])
                tet.drones.removeAt(0)
                cuadrante.jack = "Jack$i$j"
                cuadrante.vika = "Vika$i$j"
                tierra.parrilla[i][j] = cuadrante
            }
        }
    }

}