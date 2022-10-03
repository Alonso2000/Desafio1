class Reparacion(var num:Int? = null, var estadoDespues:Boolean? = null, var estadoAntes:Boolean? = null) : Orden() {

    override fun toString(): String {
        return "Reparacion(num=$num, estadoDespues=$estadoDespues, estadoAntes=$estadoAntes)"
    }

    class Builder(var num:Int? = null, var estadoDespues:Boolean? = null, var estadoAntes:Boolean? = null){
        fun num(num:Int):Builder{
            this.num = num
            return this
        }

        fun estadoDespues(estadoDespues: Boolean):Builder{
            this.estadoDespues = estadoDespues
            return this
        }

        fun estadoAntes(estadoAntes: Boolean):Builder{
            this.estadoAntes = estadoAntes
            return this
        }

        fun build(): Orden {
            return Reparacion(num, estadoDespues, estadoAntes)
        }
    }
}