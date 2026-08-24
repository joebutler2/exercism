module PerfectNumbers (classify, Classification(..)) where

data Classification = Deficient | Perfect | Abundant deriving (Eq, Show)

classify :: Int -> Maybe Classification
classify num = do
  let range = [1..(num - 1)]
  let aliquotSum = sum $ filter (\n -> num `mod` n == 0) range
  if num == 1 then Just Deficient
  else if aliquotSum <= 0 then Nothing
  else if aliquotSum == num then Just Perfect
  else if aliquotSum < num then Just Deficient
  else Just Abundant

