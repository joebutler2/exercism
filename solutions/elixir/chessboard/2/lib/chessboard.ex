defmodule Chessboard do
  def rank_range do
    1..8
  end

  def file_range do
    ?A..?H
  end

  def ranks do
    Enum.into(rank_range(), [])
  end

  def files do
    Enum.reduce(file_range(), [], fn (a_char, acc) -> acc ++ [<<a_char>>] end)
  end
end
