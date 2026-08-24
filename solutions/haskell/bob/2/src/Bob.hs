module Bob (responseFor) where

import Data.Char
import Control.Monad

notSpace :: Char -> Bool
notSpace = not . isSpace

notComma :: Char -> Bool
notComma = not . (== ',')

notSpaceOrComma :: Char -> Bool
notSpaceOrComma = liftM2 (&&) notSpace notComma

specialCharFilter :: Char -> Bool
specialCharFilter = liftM2 (&&) notSpaceOrComma isAlpha

filterMessage :: String -> String
filterMessage message = filter specialCharFilter $ init message

isShouting :: String -> Bool 
isShouting "" = False 
isShouting message = not(null cleanedMessage) && all isUpper cleanedMessage
	where cleanedMessage = filterMessage message

responseFor :: String -> String
responseFor message
  | exclamation = "Whoa, chill out!"
  | isBlank = "Fine. Be that way!"
  | lastChar == '?' = "Sure."
  | otherwise = "Whatever."
  where lastChar = last $ filter (not . isSpace) message
        isBlank = all isSpace message
        exclamation = isShouting message