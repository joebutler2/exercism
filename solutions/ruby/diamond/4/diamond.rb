class Diamond
  def initialize(end_char)
    @chars = ("A"..end_char).to_a
    @width = @chars.size * 2 - 1
  end

  def make
    half = make_recur(@chars, @width / 2)
    half[1..-1].reverse.concat(half).join("")
  end

  private

  attr_reader :width

  def make_recur(chars, offset)
    char = chars.pop()
    line = create_line
    if char == "A"
      line[mid] = char
      puts line
      return [line + "\n"]
    else
      line[mid + offset] = line[mid - offset] = char
      next_line = make_recur(chars, offset - 1)
      [line + "\n"].concat(next_line)
    end
  end

  def create_line
    " " * width
  end

  def mid 
    @mid = (width / 2).to_i
  end

  def self.make_diamond(end_char)
    # Uncomment the following line to use the logic from the instance methods.
    # return self.new(end_char).make
    chars = ("A"..end_char).to_a
    width = chars.size - 1 + chars.size
    half = make_diamond_recur(chars, width, width / 2)
    half[1..-1].reverse.concat(half).join("")
  end

  def self.make_diamond_recur(chars, width, offset)
    char = chars.pop()
    line = " " * width
    mid = (width / 2).to_i
    if char == "A"
      line[mid] = char
      return [line + "\n"]
    else
      line[mid + offset] = line[mid - offset] = char
      next_line = make_diamond_recur(chars, width, offset - 1)
      [line + "\n"].concat(next_line)
    end
  end

  def self.make_diamond_iterative(end_char)
    return "A\n" if end_char == "A"
    range = ("A"..end_char).to_a
    width = range.size
    line_width = (width - 1) + width
    base_line = " " * line_width
    diamond = []
    offset = 0
    for char in range do
      line = base_line.clone
      mid = (line_width / 2).to_i
      if char == "A"
        line[mid] = char
      else
        line[mid + offset] = line[mid - offset] = char
      end
      diamond.push(line)
      offset += 1
    end
    diamond.concat(diamond[0..-2].reverse)
    diamond.join("\n") + "\n"
  end
end

