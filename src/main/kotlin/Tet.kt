class Tet {
    var drones = ArrayList<Dron>()
    var ordenesCumplidas = ArrayList<Orden>()

    fun anadirDrones(d:Dron){
        this.drones.add(d)
    }

    fun resumenOrden(){
        for(elemento in ordenesCumplidas){
            println("$elemento, Completado(${elemento.completado})")
        }
    }

    fun totalOrdenesCumplidas():Int{
        var num:Int = ordenesCumplidas.count()
        return num
    }
    override fun toString(): String {
        return "Tet(drones=$drones)"
    }
}