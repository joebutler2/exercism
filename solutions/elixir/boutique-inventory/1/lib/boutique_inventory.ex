defmodule BoutiqueInventory do
  def sort_by_price(inventory) do
    Enum.sort_by(inventory, &(&1[:price]))
  end

  def with_missing_price(inventory) do
    Enum.filter(inventory, &(&1[:price] == nil))
  end

  def update_names(inventory, old_word, new_word) do
    Enum.map(inventory, fn (product) ->
      Map.update!(product, :name, &(
        String.replace(&1, old_word, new_word)
      ))
    end)
  end

  def increase_quantity(item, count) do
    Map.update!(item, :quantity_by_size, &(
      Enum.map(&1, fn ({size, stock}) -> {size, stock + count} end)
        |> Enum.into(%{})
    ))
  end

  def total_quantity(item) do
    item[:quantity_by_size]
      |> Map.values
      |> Enum.sum
  end
end
