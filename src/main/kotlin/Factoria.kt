import kotlin.random.Random

object Factoria {
    fun crearDron(tet:Tet){
        for(i in 0..100){
            var num:Int = Random.nextInt(1,2)
            if(num == 1){
                var d: Dron = Dron.Builder().operativo(true).build()
                tet.drones.add(d)
            }else if(num == 2){
                var d: Dron = Dron.Builder().operativo(false).build()
                tet.drones.add(d)
            }
        }
    }

    fun crearTierra():Tierra{
        var tierra:Tierra = Tierra()
        return tierra
    }


}