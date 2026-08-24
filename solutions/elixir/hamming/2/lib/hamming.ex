defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance('', ''), do: {:ok, 0}
  def hamming_distance(strand1, strand2) do
    case Enum.count(strand1) == Enum.count(strand2) do
      true -> Enum.zip(strand1, strand2)
                |> Enum.reduce({:ok, 0}, &char_check/2)
      false -> {:error, "strands must be of equal length"}
    end
  end

  @spec char_check({char, char}, {:ok, non_neg_integer}) :: {:ok, non_neg_integer} | {:error, String.t()}
  defp char_check({char1, char2}, {_, distance} = _result) do
    case char1 == char2 do
      true -> {:ok, distance}
      false -> {:ok, distance + 1}
    end
  end
end
