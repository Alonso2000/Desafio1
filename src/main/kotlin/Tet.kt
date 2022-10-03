class Tet {
    var drones = ArrayList<Dron>()

    fun anadirDrones(d:Dron){
        this.drones.add(d)
    }

    override fun toString(): String {
        return "Tet(drones=$drones)"
    }
}