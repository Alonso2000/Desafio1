class Dron {
    var id:Int = 0
    var operativo:Boolean = true

    companion object{
        var num:Int= 1
    }

    constructor(op:Boolean){
        this.operativo = op
        Dron.num++
    }

    override fun toString(): String {
        return "Dron(id=$id, operativo=$operativo)"
    }
}