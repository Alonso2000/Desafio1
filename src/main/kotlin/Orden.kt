import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Date

class Orden {
    var fecha: LocalDate? = LocalDate.now()
    var completado:Boolean = false
    var destino = Array(3){Array<Any>(3){0} }
}