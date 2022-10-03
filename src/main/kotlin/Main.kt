import kotlin.random.Random

fun main() {
    /**************************************************************
    ENLACE AL REPOSITORIO DE GITHUB:
    https://github.com/Alonso2000/Desafio1
     **************************************************************/

    //CREO LA TIERRA Y EL TET
    var tierra:Tierra = Factoria.crearTierra()
    var tet:Tet = Tet()
    var ordenesPendientes = ArrayList<Orden>()

    //AÑADO LOS DRONES AL TET
    for (i in 1..100){
        var dron:Dron = Factoria.crearDron()
        tet.anadirDrones(dron)
    }

    //CREA LOS CUADRANTES
    Factoria.crearCuadrante(tet, tierra)
    var segundos = 1
    //EMPIEZA LA SIMULACION
    for (i in tierra.parrilla.indices){
        for(j in tierra.parrilla.indices){
            println(tierra.parrilla[i][j])
        }
    }
    do{
        //CADA VEZ QUE PASAN 4 SEGUNDOS RECORRO LA PARRILLA DE LA TIERRA Y ROMPE DRONES SI TOCA UN NUMERO <= A 20 O >= A 0
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

        println("*****************************************************************")

        //CADA VEZ QUE PASAN 10 SEGUNDOS RECORRE LA PARRILLA DE LA TIERRA Y CREA LA ORDEN DE REPARACION Y LA AÑADE AL ARRAYLIST DE ORDENES PENDIENTES
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
            //TAMBIEN CREA 5 ORDENES DE RECONOCIMIENTO Y LAS AÑADE A LAS ORDENES PENDIENTES
            for(i in 0..5){
                var rec = Factoria.crearOrdenReconocimiento()
                ordenesPendientes.add(rec)
                println("AÑADIENDO ORDENES DE RECONOCIMIENTO...")
            }
        }

        println("*****************************************************************")

        /*CADA VEZ QUE PASAN 20 SEGUNDOS RECORRE EL ARRAYLIST Y DEPENDIENDO DEL TIPO DE ORDEN HACE UNA COSA O OTRA SI ES DE REPARACION REPARA LOS DRONES ROTOS
        Y LO AÑADE A UNA LISTA DE ORDENES REPARADAS*/
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
                                    elemento.completado = true
                                    tet.ordenesCumplidas.add(elemento)
                                }
                            }
                        }
                    }else{
                        //SI EL DRON ES IRREPARABLE LO SUSTITUYE COJIENDO OTRO DEL ARRAYLIST DE DRONES DEL TET SI NO HAY MAS ESE CUADRANTE SE QUEDA SIN DRON
                        elemento.estadoDespues = "Irreparable"
                        for(i in tierra.parrilla.indices) {
                            for (j in tierra.parrilla[i].indices) {
                                if(tierra.parrilla[i][j].dron.id == elemento.num){
                                    if(tet.drones.isNotEmpty()){
                                        tierra.parrilla[i][j].dron = tet.drones[0]
                                        tet.drones.removeAt(0)
                                        println("SUSTITUIMOS EL DRON DEL SECTOR[$i][$j]")
                                        elemento.completado = false
                                        tet.ordenesCumplidas.add(elemento)
                                    }else{
                                        tierra.parrilla[i][j].dron.id = null
                                        tierra.parrilla[i][j].dron.operativo = null
                                        println("NO HAY MAS DRONES EN EL TET EL SECTOR[$i][$j] SE QUEDA SIN DRON")
                                        elemento.completado = true
                                        tet.ordenesCumplidas.add(elemento)
                                    }
                                }
                            }
                        }
                    }
                    //SI ES DE RECONOCIMIENTO ASIGNA UN TIPO DE AREA A LA ORDEN DE RECONOCIMIENTO
                }else if(elemento is Reconocimiento) {
                    var areas = ArrayList<String>()
                    areas.add("Animales")
                    areas.add("Vegetales")
                    areas.add("Radiacion")
                    var num: Int = Random.nextInt(areas.size)
                    elemento.area = areas[num]
                    println("ASIGNADA AREA A LA ORDEN DE RECONOCIMIENTO ${elemento.num}")
                    elemento.completado = true
                    tet.ordenesCumplidas.add(elemento)
                }
            }
            println("*****************************************************************")
            ordenesPendientes.clear()
            tet.resumenOrden()
            println("*****************************************************************")
            var total:Int = tet.totalOrdenesCumplidas()
            println("EL NUMERO TOTAL DE ORDENES COMPLETADAS SON $total")
            for (i in tierra.parrilla.indices){
                for(j in tierra.parrilla.indices){
                    println(tierra.parrilla[i][j])
                }
            }
        }
        segundos++
        Thread.sleep(1000)
    }while(segundos < 100)
}