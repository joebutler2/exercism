=begin
Write your code for the 'Luhn' exercise in this file. Make the tests in
`luhn_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/luhn` directory.
=end

class Luhn
  class << self
    def valid?(id)
      id.gsub!(' ', '')
      return false if id.size <= 1 || id =~ /[^\d]/

      digits = convert_id_to_digits(id)
      digits = double_alternative_digits(digits)
      is_total_divisible_by_ten(digits)
    end

    private

    def convert_id_to_digits(id)
      id.split('').map(&:to_i)
    end

    def double_alternative_digits(digits)
      (digits.size - 1).downto(0) do |index|
        if is_alternative_digit?(digits, index)
          new_digit = digits[index] * 2
          new_digit = new_digit > 9 ? new_digit - 9 : new_digit
          digits[index] = new_digit
        end
      end
      digits
    end

    def is_alternative_digit?(digits, index)
      modulus_matcher = digits.size.even? ? 0 : 1
      index % 2 == modulus_matcher
    end

    def is_total_divisible_by_ten(digits)
      (digits.sum % 10).zero?
    end
  end
end

