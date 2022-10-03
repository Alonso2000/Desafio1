import java.util.Random

object Factoria {
    fun crearDron():Dron{
        var d: Dron = Dron.Builder().operativo(true).build()
        return d
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
                cuadrante.jack = "Jack[$i][$j]"
                cuadrante.vika = "Vika[$i][$j]"
                tierra.parrilla[i][j] = cuadrante
            }
        }
    }

    fun crearOrdenReparacion(num: Int?):Reparacion{
        var r :Reparacion = Reparacion.Builder().num(num).estadoAntes("Roto").build()
        return r
    }

    fun crearOrdenReconocimiento():Reconocimiento{
        var num:Int = Random().nextInt(1,20)
        var r :Reconocimiento = Reconocimiento.Builder().num(num).build()
        return r
    }

}