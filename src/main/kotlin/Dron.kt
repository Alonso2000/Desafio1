class Dron(var id: Int? = null, var operativo: Boolean? = true) {
    override fun toString(): String {
        return "Dron(id=$id, operativo=$operativo)"
    }

    class Builder(var id:Int? = num, var operativo:Boolean? = true){
        fun id(id:Int):Builder{
            this.id = id
            return this
        }

        fun operativo(operativo: Boolean):Builder{
            this.operativo = operativo
            return this
        }

        fun build():Dron{
            Dron.num++
            return Dron(id,operativo)
        }
    }
    companion object{
        var num:Int= 1
    }
}