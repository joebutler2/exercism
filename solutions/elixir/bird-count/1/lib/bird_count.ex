defmodule BirdCount do
  def today([]), do: nil
  def today([now | _]) do
    now
  end

  def increment_day_count([]), do: [1]
  def increment_day_count([today | days]) do
    [today + 1 | days]
  end

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?(list) do
    Enum.any?(list, &(&1 == 0))
  end

  # Cheat: def total(list), do: Enum.sum(list)
  def total([]), do: 0
  def total([head | tail]), do: head + total(tail)

  def busy_days([]), do: 0
  def busy_days([today | days]) when today >= 5, do: 1 + busy_days(days)
  def busy_days([_ | days]), do: busy_days(days)
end
