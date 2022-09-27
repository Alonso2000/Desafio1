import java.time.LocalDate

open class Orden {
    var fecha: LocalDate? = LocalDate.now()
    var completado:Boolean = false
    var fila:Int = 0
    var columna:Int = 0

    constructor(f:LocalDate, c:Boolean, fil:Int, col:Int){
        this.fecha = f
        this.completado = c
        this.fila = fil
        this.columna = col
    }
    override fun toString(): String {
        return "Orden(fecha=$fecha, completado=$completado, fila=$fila, columna=$columna)"
    }
}