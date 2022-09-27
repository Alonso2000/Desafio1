import java.time.LocalDate

class Reparacion : Orden {
    var num: Int = 0
    var estadoDespues: Boolean = false
    var estadoAntes: Boolean = false

    constructor(f: LocalDate, c: Boolean, fil: Int, col: Int, n: Int, ed: Boolean, ea: Boolean) : super(f, c, fil, col) {
        this.num = n
        this.estadoDespues = ed
        this.estadoAntes = ea
    }

    override fun toString(): String {
        return "Reparacion(num=$num, estadoDespues=$estadoDespues, estadoAntes=$estadoAntes)"
    }
}