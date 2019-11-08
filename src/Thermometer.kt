class Thermometer (private var sensor: Sensor){
    val observer = mutableListOf<TemperatureObserver>()

    fun measure (iterations: Int){
        for(x in 0..iterations){
            notifyOBS(sensor.getTemperature())
        }
    }

    fun register (obs : TemperatureObserver){
        observer.add(obs)
    }
    fun unregister (obs: TemperatureObserver){
        observer.remove(obs)
    }
    fun notifyOBS(value : Float){
        for(obs in observer){
            obs.update(value)
        }
    }
}