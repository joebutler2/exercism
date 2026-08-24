=begin
Write your code for the 'Luhn' exercise in this file. Make the tests in
`luhn_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/luhn` directory.
=end

class Luhn
  def self.valid?(id)
    id.gsub!(' ', '')
    return false if id.size <= 1 || id =~ /[^\d]/

    convert_id_to_digits(id)
    double_alternative_digits


    is_total_divisible_by_ten
  end

  private

  def self.convert_id_to_digits(id)
    @digits = id.split('').map(&:to_i)
  end

  def self.double_alternative_digits
    (@digits.size - 1).downto(0) do |index|
      if is_alternative_digit?(index)
        new_digit = @digits[index] * 2
        new_digit = new_digit > 9 ? new_digit - 9 : new_digit
        @digits[index] = new_digit
      end
    end
  end

  def self.is_alternative_digit?(index)
    modulus_matcher = @digits.size.even? ? 0 : 1
    index % 2 == modulus_matcher
  end

  def self.is_total_divisible_by_ten
    (@digits.inject(:+) % 10).zero?
  end
end

