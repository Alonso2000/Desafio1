import java.time.LocalDate

class Orden {
    var fecha: LocalDate? = LocalDate.now()
    var completado:Boolean = false
    var destinoFila = 0
    var destinoColumna = 0

    override fun toString(): String {
        return "Orden(fecha=$fecha, completado=$completado, destinoFila=$destinoFila, destinoColumna=$destinoColumna)"
    }


}