class Diamond
  def self.make_diamond(end_char)
    return "A\n" if end_char == "A"
    range = ("A"..end_char).to_a
    width = range.size
    line_width = (width - 1) + width
    base_line = " " * line_width
    diamond = []
    inner_offset = 0
    for char in range do
      line = base_line.clone
      mid = (line_width / 2).to_i
      if char == "A"
        line[mid] = char
      else
        line[mid + inner_offset] = char
        line[mid - inner_offset] = char
      end
      diamond.push(line)
      inner_offset += 1
    end
    diamond.concat(diamond[0..-2].reverse)
    diamond.join("\n") + "\n"
  end
end

