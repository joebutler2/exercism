defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t(), [String.t()]) :: [String.t()]
  def match(base, candidates) do
    base = String.downcase(base)
    candidates
      |> Enum.filter(fn candidate -> base != String.downcase(candidate) end)
      |> Enum.filter(fn candidate -> match_word(base, String.downcase(candidate)) end)
  end

  def match_word(word, to_match) do
    char_frequencies(word) == char_frequencies(to_match)
  end

  def char_frequencies(word) do
    Enum.frequencies(String.graphemes(word))
  end
end
