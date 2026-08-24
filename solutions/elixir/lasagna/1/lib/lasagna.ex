defmodule Lasagna do
  @cooking_time 40

  def expected_minutes_in_oven() do
    @cooking_time
  end

  def remaining_minutes_in_oven(duration) do
    @cooking_time - duration
  end

  def preparation_time_in_minutes(layer_count) do
    layer_count * 2
  end
 
  def total_time_in_minutes(layer_count, duration) do
    preparation_time_in_minutes(layer_count) + duration
  end

  def alarm() do
    "Ding!"
  end

end
