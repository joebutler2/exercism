defmodule LibraryFees do
  def datetime_from_string(string) do
    NaiveDateTime.from_iso8601!(string)
  end

  def before_noon?(datetime) do
    datetime.hour < 12
  end

  def return_date(checkout_datetime) do
    days = if before_noon?(checkout_datetime), do: 28, else: 29
    Date.add(checkout_datetime, days)
  end

  def days_late(planned_return_date, actual_return_datetime) do
    {_, checkout} = DateTime.new(planned_return_date, ~T[00:00:00], "Etc/UTC")
    days = Date.diff(actual_return_datetime, checkout)
    if days >= 0, do: days, else: 0
  end

  def monday?(%NaiveDateTime{} = datetime) do
    date = NaiveDateTime.to_date(datetime)
    Date.beginning_of_week(date) == date
  end
  def monday?(%Date{} = date) do
    Date.beginning_of_week(date) == date
  end

  def calculate_late_fee(checkout, return, rate) do
    planned_return_date = return_date(datetime_from_string(checkout))
    actual_return_date = datetime_from_string(return)
    monday_discount = if monday?(actual_return_date), do: 0.5, else: 1.0
    days = days_late(planned_return_date, actual_return_date)
    Float.floor(days * rate * monday_discount)
  end
end
