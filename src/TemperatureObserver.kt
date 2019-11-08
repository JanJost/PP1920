interface TemperatureObserver{
    fun update(value :Float)
}

/*Observer*/

class TemperatureAlert : TemperatureObserver{
    private val alertTemperature=40
    override fun update(value: Float) {
        if(value>alertTemperature){
            println("Das ist aber heiß!!")
        }
    }
}
class WeatherReport : TemperatureObserver{
    private var weatherData = mutableListOf<Float>()
    private var counter=0
    override fun update(value: Float) {
        weatherData.add(value)
        counter++
        if(counter==100){
            println("die letzten hundert Temperaturen: ")
            for(i in weatherData){
                println(i)
            }
            weatherData.clear()
            counter=0
        }
    }
}
class HeatingSystem : TemperatureObserver{
    private var weatherData = mutableListOf<Float>()
    private var counter=0
    private var HeatingStrategy: HeatingStrategy =ReasonableHeatingStrategy()
    override fun update(value: Float) {
        weatherData.add(value)
        counter++
        if(weatherData.size==10){
            if(HeatingStrategy.needsHeating(weatherData)){
                println("Heizung an")
            }
            else{
                println("Heizung aus")
            }

        }
    }
}