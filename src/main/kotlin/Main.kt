import java.util.Currency
import kotlin.random.Random

fun main() {
    var tierra:Tierra = Factoria.crearTierra()
    var tet:Tet = Tet()

    for (i in 0..100){
        var dron:Dron = Factoria.crearDron()
        tet.anadirDrones(dron)
    }

    println(tet)

    Factoria.crearCuadrante(tet, tierra)
    var segundos = 1
    do{
        for(i in tierra.parrilla.indices){
            for(j in tierra.parrilla[i].indices) {
                print("${tierra.parrilla[i][j]} ")
            }
            println()
        }

        if (segundos % 4 == 0) {
            for(i in tierra.parrilla.indices){
                for(j in tierra.parrilla[i].indices){
                    var estropeado:Int = Random.nextInt(0,100)
                    if(estropeado in 0..20){
                        tierra.parrilla[i][j].dron.operativo = false
                    }
                }
            }
        }
        segundos++
        Thread.sleep(1000)
    }while(segundos < 100)
}