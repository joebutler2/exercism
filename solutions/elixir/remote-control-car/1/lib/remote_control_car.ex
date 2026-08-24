defmodule RemoteControlCar do
  @enforce_keys [:nickname]
  defstruct [
    battery_percentage: 100,
    distance_driven_in_meters: 0,
    nickname: nil
  ]

  def new() do
    %RemoteControlCar{nickname: "none"}
  end

  def new(nickname) do
    %RemoteControlCar{nickname: nickname}
  end

  def display_distance(remote_car = %RemoteControlCar{}) do
    "#{remote_car.distance_driven_in_meters} meters"
  end

  def display_battery(remote_car = %RemoteControlCar{}) do
    if remote_car.battery_percentage > 0 do
      "Battery at #{remote_car.battery_percentage}%"
    else
      "Battery empty"
    end
  end

  def drive(remote_car = %RemoteControlCar{}) do
    if remote_car.battery_percentage > 0 do
      remote_car = %{remote_car | battery_percentage: remote_car.battery_percentage - 1}
      %{remote_car
              | distance_driven_in_meters: remote_car.distance_driven_in_meters + 20}
    else
      remote_car
    end
  end
end
