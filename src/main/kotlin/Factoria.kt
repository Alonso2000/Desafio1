class Factoria {
    fun crearDron(tet:Tet){
        for(i in 0..100){
            var d: Dron = Dron.Builder().build()
            tet.drones.add(d)
        }
    }
}