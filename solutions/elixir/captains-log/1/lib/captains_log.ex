defmodule CaptainsLog do
  @planetary_classes ["D", "H", "J", "K", "L", "M", "N", "R", "T", "Y"]

  def random_planet_class() do
    random_elem(@planetary_classes)
  end

  def random_ship_registry_number() do
    "NCC-#{random_elem(1000..9999)}"
  end

  @stardate_beginning 41000.0
  @stardate_end 42000.0
  def random_stardate() do
    :random.uniform() * (@stardate_end - @stardate_beginning) + @stardate_beginning
  end

  def format_stardate(stardate) do
    "~.1f" |> :io_lib.format([stardate]) |> to_string
  end

  defp random_elem(%Range{} = coll) do
    random_elem(Enum.to_list(coll))
  end
  defp random_elem(coll) when is_list(coll) do
    index = length(coll)
      |> :random.uniform
    Enum.at(coll, index - 1)
  end
end
