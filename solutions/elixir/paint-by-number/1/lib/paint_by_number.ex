defmodule PaintByNumber do
  def palette_bit_size(color_count) do
    _palette_bit_size(0, color_count)
  end
  defp _palette_bit_size(bit_size, color_count) do
    result = Math.pow(2, bit_size)
    cond do
      result < color_count -> _palette_bit_size(bit_size + 1, color_count)
      true -> bit_size
    end
  end

  def empty_picture() do
    <<>>
  end

  def test_picture() do
    <<0b00::2, 0b01::2, 0b10::2, 0b11::2>>
  end

  def prepend_pixel(picture, color_count, pixel_color_index) do
    bit_size = palette_bit_size(color_count)
    <<pixel_color_index::size(bit_size), picture::bitstring>>
  end

  def get_first_pixel("", _color_count), do: nil
  def get_first_pixel(picture, color_count) do
    bit_size = palette_bit_size(color_count)
    <<value::size(bit_size), rest::bitstring>> = picture
    value
  end

  def drop_first_pixel("", _color_count), do: <<>>
  def drop_first_pixel(picture, color_count) do
    bit_size = palette_bit_size(color_count)
    <<value::size(bit_size), rest::bitstring>> = picture
    rest
  end

  def concat_pictures("", ""), do: <<>>
  def concat_pictures(picture1, picture2) do
    <<picture1::bitstring, picture2::bitstring>>
  end
end
