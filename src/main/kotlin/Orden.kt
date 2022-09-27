import java.time.LocalDate

class Orden {
    var fecha: LocalDate? = LocalDate.now()
    var completado:Boolean = false
    var destino = Array(3){Array<Any>(3){0} }


    override fun toString(): String {
        return "Orden(fecha=$fecha, completado=$completado, destino=${destino.contentToString()})"
    }


}