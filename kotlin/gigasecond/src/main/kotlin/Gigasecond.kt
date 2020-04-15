import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.Temporal
import java.time.temporal.TemporalUnit

class Gigasecond {
  var date: LocalDateTime? = null
  val billion: Long = 1_000_000_000

  constructor(date: LocalDate) {
    this.date = date.atStartOfDay().plusSeconds(billion)
  }

  constructor(date: LocalDateTime) {
    this.date = date.plusSeconds(billion)
  }


}