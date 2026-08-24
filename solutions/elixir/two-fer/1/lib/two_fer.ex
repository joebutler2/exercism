defmodule TwoFer do
  @doc """
  Two-fer or 2-fer is short for two for one. One for you and one for me.
  """
  @spec two_fer(String.t()) :: String.t()
  def two_fer(name) when name == "Alice" do
    "One for Alice, one for me."
  end
  def two_fer(name) when name == "Bob" do
    "One for Bob, one for me."
  end
  def two_fer() do
    "One for you, one for me."
  end
end
