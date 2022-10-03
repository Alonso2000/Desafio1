class Reparacion(var num:Int? = null, var estadoDespues:String? = null, var estadoAntes:String? = null) : Orden() {

    override fun toString(): String {
        return "Reparacion(num=$num, estadoDespues=$estadoDespues, estadoAntes=$estadoAntes)"
    }

    class Builder(var num:Int? = null, var estadoDespues:String? = null, var estadoAntes:String? = null){
        fun num(num: Int?):Builder{
            this.num = num
            return this
        }

        fun estadoDespues(estadoDespues: String):Builder{
            this.estadoDespues = estadoDespues
            return this
        }

        fun estadoAntes(estadoAntes: String):Builder{
            this.estadoAntes = estadoAntes
            return this
        }

        fun build(): Reparacion {
            return Reparacion(num, estadoDespues, estadoAntes)
        }
    }
}