=begin
Write your code for the 'Twelve Days' exercise in this file. Make the tests in
`twelve_days_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/twelve-days` directory.
=end
class TwelveDays
  GIFTS = [
    "a Partridge in a Pear Tree",
    "two Turtle Doves",
    "three French Hens",
    "four Calling Birds",
    "five Gold Rings",
    "six Geese-a-Laying",
    "seven Swans-a-Swimming",
    "eight Maids-a-Milking",
    "nine Ladies Dancing",
    "ten Lords-a-Leaping",
    "eleven Pipers Piping",
    "twelve Drummers Drumming"
  ]

  def self.song
    %w[first second third fourth fifth sixth seventh eighth
       ninth tenth eleventh twelfth].map.with_index do |ordinal_day, index|
      opening_clause(ordinal_day) + " #{gifts_clause(index)}."
    end.join("\n\n") + "\n"
  end

  def self.opening_clause(ordinal_day)
    "On the #{ordinal_day} day of Christmas my true love gave to me:"
  end

  def self.gifts_clause(starting_index)
    gifts = starting_index.downto(0).inject([]) do |acc, gift_index|
      acc << GIFTS[gift_index]
      acc
    end
    return gifts.first if gifts.size == 1
    last_gift = gifts.pop
    gifts.join(", ") + ", and #{last_gift}"
  end
end

