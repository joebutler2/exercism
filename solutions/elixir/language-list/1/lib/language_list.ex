defmodule LanguageList do
  def new() do
    []
  end

  def add(list, language) do
    [language | list]
  end

  def remove(list) do
    [head | tail] = list
    tail
  end

  def first(list) do
    [head | tail] = list
    head
  end

  def count([]), do: 0
  def count(list), do: count(list, 0)
  def count([], acc), do: acc
  def count(list, acc) do
    [head | tail] = list
    count(tail, acc + 1)
  end

  def functional_list?(list) do
    "Elixir" in list
  end
end
