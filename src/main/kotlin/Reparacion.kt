import kotlin.random.Random

class Reparacion(var num:Int? = null, var estadoDespues:String? = null, var estadoAntes:String? = null) : Orden() {

    override fun toString(): String {
        return "Reparacion(num=$num, estadoDespues=$estadoDespues, estadoAntes=$estadoAntes)"
    }

    fun reparar():Boolean{
        var reparar:Boolean = false
        var num:Int = Random.nextInt(0,100)
        if(num in 0..50){
            reparar = true
        }
        return reparar
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