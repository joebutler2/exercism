module Acronym (abbreviate) where
import Data.Char

abbreviate :: String -> String
abbreviate xs = do
  map (toUpper . head) $ words xs
  -- let wordsList = (words xs)
  -- let rawAbbr = map head wordsList
  -- toUpper rawAbbr

