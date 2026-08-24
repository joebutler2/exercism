module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance xs ys = do
  if (length xs) /= (length ys)
  then Nothing
  else do
    let zz = zip xs ys
    let total = foldl (\acc (a, b) -> acc + (if a == b then 0 else 1)) 0 zz
    Just total
