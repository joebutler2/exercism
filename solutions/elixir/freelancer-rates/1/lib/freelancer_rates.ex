defmodule FreelancerRates do
  @daily_business_hours 8.0  
  @monthly_business_days_count 22

  def daily_rate(hourly_rate) do
    hourly_rate * @daily_business_hours
  end

  def apply_discount(before_discount, discount) do
    discount_total = before_discount * discount / 100
    before_discount - discount_total
  end

  def monthly_rate(hourly_rate, discount) do
    apply_discount(daily_rate(hourly_rate) * @monthly_business_days_count, discount)
      |> ceil
  end

  def days_in_budget(budget, hourly_rate, discount) do
    discounted_rate = apply_discount(hourly_rate, discount)
      |> daily_rate
    Float.floor(budget / discounted_rate, 1)
  end
end
