class Cuadrante {
    var drones = ArrayList<Dron>()
    val vika:String = "Vika$num"
    val jack:String = "Jack$num"

    companion object{
        var num:Int= 1
    }

    constructor(){
        Cuadrante.num++
    }

    override fun toString(): String {
        return "Cuadrante(drones=$drones, vika='$vika', jack='$jack')"
    }
}