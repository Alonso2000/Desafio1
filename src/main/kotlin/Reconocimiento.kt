class Reconocimiento(var num:Int? = null, var area:String? = null) : Orden() {

    override fun toString(): String {
        return "Reconocimiento(num=$num, area='$area')"
    }

    class Builder(var num:Int? = null, var area:String? = null){
        fun num(num:Int):Builder{
            this.num = num
            return this
        }

        fun area(area: String):Builder{
            this.area = area
            return this
        }

        fun build(): Reconocimiento {
            return Reconocimiento(num, area)
        }
    }
}