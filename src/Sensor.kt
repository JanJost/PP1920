interface Sensor{
    fun getTemperatur() : Float
}

class RandomSensor : Sensor{
    override fun getTemperatur(): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class UpDownSensor : Sensor{
    override fun getTemperatur(): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

open class SensorLimit (val decoratedSensor: Sensor){
    override fun getTemperatur(): Float{

    }
}