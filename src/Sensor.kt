import kotlin.random.Random
import kotlin.math.round

interface Sensor{
    fun getTemperature() : Float
}

class RandomSensor : Sensor{
    private val min=-40  //-37,8 Tiefsttemperatur Deutschland
    private val max= 45  //42,6 Höchsttemperatur Deutschland
    override fun getTemperature(): Float {return min +Random.nextFloat()*(max-min)}
    }

class UpDownSensor : Sensor {  //von Joel Mai inf166
    private var aktTemperature = 10F

    override fun getTemperature(): Float {
        var schwankung: Float = Random.nextFloat()
        var schwankungCause: Int = Random.nextInt(1, 4)

        when (schwankungCause) {
            1 -> aktTemperature += schwankung
            2 -> aktTemperature -= schwankung
            3 -> aktTemperature
            else -> { // Note the block
                print("Fehler: SchwankungCause liefert falsche Werte")
            }
        }
        return aktTemperature
    }
}

/*Decorierer*/

open class SensorLogger (var decoratedSensor: Sensor): Sensor{
    override fun getTemperature(): Float{
        val temp=decoratedSensor.getTemperature()
        println("Temperatur: $temp")
        return temp
    }

}
open class RoundValues (var decoratedSensor: Sensor): Sensor{
    override fun getTemperature(): Float{
        return round(decoratedSensor.getTemperature())
    }

}
open class SensorLimits (var decoratedSensor: Sensor): Sensor{
    private val min= 10
    private val max= 20
    override fun getTemperature(): Float{
        while(true){
           val temp= decoratedSensor.getTemperature()
            if(min<temp && temp<max){
            return temp
            }
        }
    }
}
open class IgnoreDublicates (var decoratedSensor: Sensor): Sensor{
    private var lastValue=0.0F
    override fun getTemperature(): Float{
        while(true){
            val temp= round(decoratedSensor.getTemperature()*100)/100
            if(lastValue != temp){
                lastValue=temp
                return temp
            }
        }
    }
}