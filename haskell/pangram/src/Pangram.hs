module Pangram (isPangram) where
import Data.Char

-- iterate over each char in alpha, see if char is an "elem" of the input string
full_alphabet = ['a'..'z']

hasFullAlpha :: String -> Bool
hasFullAlpha string = all (\s -> s `elem` string) full_alphabet

isPangram :: String -> Bool
isPangram "" = False
isPangram text = hasFullAlpha(map toLower text)
