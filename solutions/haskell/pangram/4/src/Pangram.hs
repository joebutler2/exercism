module Pangram (isPangram) where
import Data.Char (toLower)
import Data.Set (fromList, member)

isPangram :: String -> Bool
isPangram rawText =
  all (`member` text) ['a'..'z']
  where text = fromList $ map toLower rawText

