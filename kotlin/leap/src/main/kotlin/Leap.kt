class Year {
  var isLeap: Boolean = false

  constructor(year: Int) {
    isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
  }
}