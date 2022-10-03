import kotlin.random.Random

fun main() {
    var tierra:Tierra = Factoria.crearTierra()
    var tet:Tet = Tet()
    var ordenesPendientes = ArrayList<Orden>()

    for (i in 0..100){
        var dron:Dron = Factoria.crearDron()
        tet.anadirDrones(dron)
    }

    Factoria.crearCuadrante(tet, tierra)
    var segundos = 1
    do{
        /*for(i in tierra.parrilla.indices){
            for(j in tierra.parrilla[i].indices) {
                print("${tierra.parrilla[i][j]} ")
            }
            println()
        }*/

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
        println()
        if (segundos % 10 == 0) {
            for(i in tierra.parrilla.indices){
                for(j in tierra.parrilla[i].indices){
                    if(tierra.parrilla[i][j].dron.operativo == false){
                        var rep = Factoria.crearOrdenReparacion(tierra.parrilla[i][j].dron.id)
                        ordenesPendientes.add(rep)
                    }
                }
            }
            for(i in 0..5){
                var rec = Factoria.crearOrdenReconocimiento()
                ordenesPendientes.add(rec)
            }
        }
        println(ordenesPendientes)
        segundos++
        Thread.sleep(1000)
    }while(segundos < 100)
}