=begin
Write your code for the 'Clock' exercise in this file. Make the tests in
`clock_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/clock` directory.
=end

class Clock
  def initialize(hour: 0, minute: 0)
    @hour = hour.positive? ? hour : 24 + (hour % 24)
    if minute >= 60
      @hour += minute / 60
      @minute = minute % 60
    else
      if minute >= 0
        @minute = minute
      else
        minute = minute.abs
        minute_offset = minute <= 60 ? minute : minute % 60
        @minute = 60 - minute_offset
        hours_to_rewind = (minute / 60.0).ceil
        if @hour < hours_to_rewind
          @hour += 24 - (hours_to_rewind % 24)
        else
          @hour -= hours_to_rewind
        end
      end
    end
    @hour = @hour >= 24 ? @hour % 24 : @hour
  end

  def +(other)
    Clock.new(
      hour: hour + other.hour,
      minute: minute + other.minute
    )
  end

  def -(other)
    Clock.new(
      hour: hour - other.hour,
      minute: minute - other.minute
    )
  end

  def ==(other)
    hour == other.hour &&
      minute == other.minute
  end

  def to_s
    hour = sprintf("%02d", @hour)
    minute = sprintf("%02d", @minute)
    [hour, minute].join(":")
  end

  protected

  def hour
    @hour
  end

  def minute
    @minute
  end
end

