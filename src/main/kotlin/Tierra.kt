class Tierra {
    var cuadrante = Array(3){Array<Any>(3){0} }
    val vika:String = "Vika$num"
    val jack:String = "Jack$num"

    companion object{
        var num:Int= 1
    }

    constructor(){
        Tierra.num++
    }

    override fun toString(): String {
        return "Tierra(cuadrante=${cuadrante.contentToString()}, vika='$vika', jack='$jack')"
    }
}