defmodule BasketballWebsite do
  def extract_from_path(nil, path), do: nil
  def extract_from_path(data, path) do
    _extract_from_path(data, String.split(path, "."))
  end

  defp _extract_from_path(data, []), do: data
  defp _extract_from_path(data, [attr | path]) do
    _extract_from_path(data[attr], path)
  end

  def get_in_path(data, path) do
    Kernel.get_in(data, String.split(path, "."))
  end
end
