class Dron(id: Int?, operativo: Boolean?) {
    var id:Int = 0
    var operativo:Boolean = true

    /*companion object{
        var num:Int= 1
    }*/

    /*constructor(op:Boolean){
        this.operativo = op
        Dron.num++
    }*/

    override fun toString(): String {
        return "Dron(id=$id, operativo=$operativo)"
    }

    class Builder(var id:Int? = null, var operativo:Boolean? = null){
        fun id(id:Int):Builder{
            this.id = id
            return this
        }

        fun operativo(operativo: Boolean):Builder{
            this.operativo = operativo
            return this
        }

        fun build():Dron{
            return Dron(id,operativo)
        }
    }
}