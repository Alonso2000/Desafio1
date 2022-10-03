class Cuadrante {
    var dron:Dron = Dron()
    var vika:String = "Vika"
    var jack:String = "Jack"

    constructor(d:Dron){
        this.dron = d
    }

    override fun toString(): String {
        return "Cuadrante(dron=$dron, vika='$vika', jack='$jack')"
    }
}