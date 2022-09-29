import java.time.LocalDate

class Reconocimiento : Orden {
    var num = 0
    var area:String = ""

    constructor(f:LocalDate, c:Boolean, fil:Int, col:Int, n:Int, a:String) : super(f,c,fil,col){
        this.num = n
        this.area = a
    }

    override fun toString(): String {
        return "Reconocimiento(num=$num, area='$area')"
    }


}