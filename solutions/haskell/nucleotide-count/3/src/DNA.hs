module DNA (nucleotideCounts, Nucleotide(..)) where
import Data.Map (Map, adjust, fromList)
import Text.Read (readEither)
import Data.Either (partitionEithers)

data Nucleotide = A | C | G | T deriving (Ord, Eq, Show, Read)

toNuc :: Char -> Either String Nucleotide
toNuc x = readEither [x]

convert :: String -> [Either String Nucleotide]
convert xs = Prelude.map toNuc xs

count :: (Num a) => Map Nucleotide a -> [Nucleotide] -> Map Nucleotide a
count freq [] = freq
count freq (x:xs) = count inc xs where inc = (adjust (+ 1) x freq)

nucleotideCounts :: String -> Either String (Map Nucleotide Int)
nucleotideCounts xs = do
  if length invalid > 0
  then Left ""
  else Right (count freq valid) 
    where
      (invalid, valid) = partitionEithers $ convert xs
      freq = fromList([(A, 0), (C, 0), (G, 0), (T, 0)])
