class Tierra {
    var parrilla = Array(3) { Array<Any>(3) {0} }

    constructor(p:Array<Array<Any>>){
        this.parrilla = p
    }
    override fun toString(): String {
        return "Tierra(parrilla=${parrilla.contentToString()})"
    }
}