fun main(){
    val tm1 = Thermometer(RoundValues(RandomSensor()))
    val tm2 = Thermometer(SensorLimits(UpDownSensor()))
    val tm3 = Thermometer(SensorLogger(UpDownSensor()))
    val tm4 = Thermometer(IgnoreDublicates(UpDownSensor()))

    tm1.register(WeatherReport())
    tm1.register(HeatingSystem())
    tm1.register(HeatingSystem())
    tm1.register(HeatingSystem())
    tm2.register(HeatingSystem())
    tm2.register(TemperatureAlert())
    tm2.register(WeatherReport())
    tm3.register(WeatherReport())
    tm3.register(HeatingSystem())

   // tm1.measure(1000)
    tm2.measure(1000)
    tm3.measure(103)


}