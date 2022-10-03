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


}