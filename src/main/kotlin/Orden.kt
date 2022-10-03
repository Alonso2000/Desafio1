import java.time.LocalDate

//ME QUEDA EN EL PENSAMIENTO QUE ESTA CLASE DEBERIA DE SER ABSTRACTA PERO NO ESTOY MUY SEGURO
open class Orden(var fecha: LocalDate? = null, var completado: Boolean? = null, var fila: Int? = null, var columna: Int? = null) {

    override fun toString(): String {
        return "Orden(fecha=$fecha, completado=$completado, fila=$fila, columna=$columna)"
    }

    class Builder(var fecha:LocalDate? = null, var completado:Boolean? = null, var fila:Int? = null, var columna:Int? = null){
        fun fecha(fecha:LocalDate):Builder{
            this.fecha = fecha
            return this
        }

        fun completado(completado: Boolean):Builder{
            this.completado = completado
            return this
        }

        fun fila(fila: Int):Builder{
            this.fila = fila
            return this
        }

        fun columna(columna: Int):Builder{
            this.columna = columna
            return this
        }

        fun build(): Orden {
            return Orden(fecha, completado, fila, columna)
        }
    }
}