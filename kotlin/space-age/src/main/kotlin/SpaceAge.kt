import kotlin.math.round

class SpaceAge(ageInSeconds: Long) {
  val earthYearInSeconds = 315576.000
  val earthYearsRaw = ageInSeconds / earthYearInSeconds

  private fun ageBy(oribitalPeriod: Double) =
    round(this.earthYearsRaw / oribitalPeriod) / 100

  fun onEarth(): Double {
    return round(this.earthYearsRaw) / 100
  }

  fun onMercury(): Double {
    return ageBy(0.2408467)
  }

  fun onVenus(): Double {
    return ageBy(0.61519726)
  }

  fun onMars(): Double {
    return ageBy(1.8808158)
  }

  fun onJupiter(): Double {
    return ageBy(11.862615)
  }

  fun onSaturn(): Double {
    return ageBy(29.447498)
  }

  fun onUranus(): Double {
    return ageBy(84.016846)
  }

  fun onNeptune(): Double {
    return ageBy(164.79132)
  }

}
