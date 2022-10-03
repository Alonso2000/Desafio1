class Tet {
    var drones = ArrayList<Dron>()
    var ordenesCumplidas = ArrayList<Orden>()

    fun anadirDrones(d:Dron){
        this.drones.add(d)
    }

    fun resumenOrden()String{

    }
    override fun toString(): String {
        return "Tet(drones=$drones)"
    }
}