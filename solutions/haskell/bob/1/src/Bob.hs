module Bob (responseFor) where
import Data.Char (isUpper)


isExclamation :: String -> Bool 
isExclamation "" = False 
isExclamation message = all isUpper (take ((length message) - 1) message)

responseFor :: String -> String
responseFor message
 | exclamation = "Whoa, chill out!"
 | lastChar == '?' = "Sure."
 | otherwise = "Whatever."
 where lastChar = last message
       allCaps  = all isUpper message
       exclamation = isExclamation message