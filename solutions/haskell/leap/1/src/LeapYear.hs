module LeapYear (isLeapYear) where

isLeapYear :: Integer -> Bool
isLeapYear year
  | divisibleBy4 && notDivisibleBy100 = True
  | divisibleBy400 = True
  | otherwise = False
  where
    divisibleBy4 = (mod year 4) == 0
    divisibleBy400 = (mod year 400) == 0
    notDivisibleBy100 = not((mod year 100) == 0)