module Acronym (abbreviate) where
import Data.Char

abbreviate :: String -> String
abbreviate xs = do
  map (toUpper . head) $ words (splitCamelCase $ sanitize xs)

-- The easiest path forward was to ignore any apostrophes. Since they suffix words
-- they naturally wont be used.
sanitize :: String -> String
sanitize [] = []
sanitize (x:xs) = (if (isAlpha x) || (isSpace x) || (x == '\'') then x else ' ') : sanitize xs

splitCamelCase :: String -> String
splitCamelCase [] = []
splitCamelCase (x:xs) = (if (isLower x) && (length xs) > 0 && (isUpper (head xs))
                         then [x] ++ " "
                         else [x]) ++ splitCamelCase xs
-- splitCamelCase (x:xs) = (if (isLower x) && (isUpper (head xs)) then " " ++ [x] else [x]) ++ splitCamelCase xs


