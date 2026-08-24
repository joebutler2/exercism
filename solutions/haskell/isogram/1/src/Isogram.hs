module Isogram (isIsogram) where
import qualified Data.Map as Map
import Data.Char (toLower, isAlpha)

isIsogram :: String -> Bool
isIsogram s = do
  let santizedString = filter isAlpha $ map toLower s
  let freqs = frequencies (Map.singleton 'a' 0) $ santizedString
  (0 ==) $ length $ Map.filter (\v -> v > 1) freqs

frequencies :: Num v => (Map.Map Char v) -> String -> (Map.Map Char v)
frequencies mp "" = mp
frequencies mp (x:xs) = if Map.member x mp
  then frequencies (Map.adjust (+ 1) x mp) xs
  else frequencies (Map.insert x 1 mp) xs
