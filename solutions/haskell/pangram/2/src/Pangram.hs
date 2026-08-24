module Pangram (isPangram) where
import Data.Char
import Data.Set (fromList, member)

isPangram :: String -> Bool
isPangram rawText = do
  all (`member` text) ['a'..'z']
  where text = fromList $ map toLower rawText

