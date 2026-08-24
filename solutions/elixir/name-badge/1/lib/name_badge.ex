defmodule NameBadge do
  def print(nil, name, department), do: _print(name, department)
  def print(id, name, department) do
    "[#{id}] - " <> _print(name, department)
  end

  defp _print(name, nil), do: _print(name, "owner")
  defp _print(name, department) do
    "#{name} - #{String.upcase(department)}"
  end
end
