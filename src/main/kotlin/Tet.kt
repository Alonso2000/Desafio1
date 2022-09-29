class Tet {
    var drones = ArrayList<Dron>()

    constructor(d:ArrayList<Dron>){
        this.drones = d
    }
    override fun toString(): String {
        return "Tet(drones=$drones)"
    }
}