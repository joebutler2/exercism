module Pangram (isPangram) where
import Data.Char
full_alphabet = ['a'..'z']

-- iterate over each char in alpha, see if char is an "elem" of the input string
--

removeLowerCase string = [char | char <- string, elem char full_alphabet]

hasFullAlpha :: String -> Bool
hasFullAlpha string = all (\s -> s `elem` string) full_alphabet
--extract string = [char | char <- string, takeWhile (char `elem` full_alphabet) full_alphabet]


isPangram :: String -> Bool
isPangram "" = False
isPangram text = hasFullAlpha(map toLower text)
