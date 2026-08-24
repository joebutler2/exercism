module Phone (number) where
import Data.Char (isNumber)
import Data.Set (Set, fromList, member)
-- Validation format: (NXX)-NXX-XXXX where X is 0-9 and N is 2-9 

removeCountryCode :: String -> String
removeCountryCode xs = if (head xs) == '1'
                       then tail xs
                       else xs

-- Set for the valid numbers (as strings) for the "N" slots
validNumbersForN :: Set [Char]
validNumbersForN = fromList $ map show [2..9]

-- For individual characters
validateNumber :: Char -> Bool
validateNumber c = member [c] validNumbersForN

validatePhoneNumber :: String -> Bool
validatePhoneNumber phoneNumber = do
  (length phoneNumber) == 10 &&
   (validateNumber $ phoneNumber !! 0) &&
     (validateNumber $ phoneNumber !! 3)  

number :: String -> Maybe String
number xs = do
  let rawNumber = removeCountryCode $ filter isNumber xs
  if (validatePhoneNumber rawNumber)
  then Just rawNumber
  else Nothing
  
