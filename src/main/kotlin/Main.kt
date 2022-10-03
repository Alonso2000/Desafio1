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
                        println("EL DRON DEL SECTOR[$i][$j] SE A ROTO")
                    }
                }
            }
        }

        println("******************************************")

        if (segundos % 10 == 0) {
            for(i in tierra.parrilla.indices){
                for(j in tierra.parrilla[i].indices){
                    if(tierra.parrilla[i][j].dron.operativo == false){
                        var rep = Factoria.crearOrdenReparacion(tierra.parrilla[i][j].dron.id)
                        ordenesPendientes.add(rep)
                        println("HAN SIDO ENCONTRADOS DRONES ROTOS, AÑADIENDO ORDENES DE REPARACION...")
                    }
                }
            }
            for(i in 0..5){
                var rec = Factoria.crearOrdenReconocimiento()
                ordenesPendientes.add(rec)
                println("AÑADIENDO ORDENES DE RECONOCIMIENTO...")
            }
        }

        println("******************************************")

        if (segundos % 20 == 0) {
            var reparado:Boolean = false
            for(elemento in ordenesPendientes){
                if(elemento is Reparacion){
                    reparado = elemento.reparar()
                    if(reparado == true){
                        elemento.estadoDespues = "Reparado"
                        for(i in tierra.parrilla.indices) {
                            for (j in tierra.parrilla[i].indices) {
                                if(tierra.parrilla[i][j].dron.id == elemento.num){
                                    tierra.parrilla[i][j].dron.operativo = true
                                    println("EL DRON DEL SECTOR[$i][$j] A SIDO REPARADO")
                                    tet.ordenesCumplidas.add(elemento)
                                }
                            }
                        }
                    }else{
                        elemento.estadoDespues = "Irreparable"
                        for(i in tierra.parrilla.indices) {
                            for (j in tierra.parrilla[i].indices) {
                                if(tierra.parrilla[i][j].dron.id == elemento.num){
                                    if(tet.drones.isNotEmpty()){
                                        tierra.parrilla[i][j].dron = Factoria.crearDron()
                                        println("SUSTITUIMOS EL DRON DEL SECTOR[$i][$j]")
                                        tet.ordenesCumplidas.add(elemento)
                                    }else{
                                        tierra.parrilla[i][j].dron.id = null
                                        tierra.parrilla[i][j].dron.operativo = null
                                        println("NO HAY MAS DRONES EN EL TET EL SECTOR[$i][$j] SE QUEDA SIN DRON")
                                        tet.ordenesCumplidas.add(elemento)
                                    }
                                }
                            }
                        }
                    }
                }else if(elemento is Reconocimiento) {
                    var areas = Array<String>(2) { "Animales"; "Vegetales"; "Radiacion" }
                    var num: Int = Random.nextInt(areas.size)
                    elemento.area = areas[num]
                    println("ASIGNADA AREA A LA ORDEN DE RECONOCIMIENTO ${elemento.num}")
                    tet.ordenesCumplidas.add(elemento)
                }
            }
            ordenesPendientes.clear()
        }
        segundos++
        Thread.sleep(1000)
    }while(segundos < 100)
}