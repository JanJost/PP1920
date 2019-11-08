interface HeatingStrategy{
    fun needsHeating ( last10measurements : List<Float>) : Boolean
}
/*Strategies*/

class InstantHeatingStrategy : HeatingStrategy {

    override fun needsHeating(last10measurements: List<Float>): Boolean {
        if(last10measurements.last()<19){
            return true
        }
        return false
    }
}

class SensibleHeatingStrategy : HeatingStrategy {
    val underTwenty: (Float) -> Boolean ={it <20}
    override fun needsHeating(last10measurements: List<Float>): Boolean {
        if(last10measurements.any{underTwenty(it)}){return true}
        return false
    }
}

class ReasonableHeatingStrategy : HeatingStrategy {
    private var counter =0
    override fun needsHeating(last10measurements: List<Float>): Boolean {
        last10measurements.forEach() {
            if (it < (15).toFloat()) {
                return true
            }
            if (it < (19).toFloat()) {
                counter++
            }
            if (counter >= 5) {
                return true
            }
        }
            return false
    }
}