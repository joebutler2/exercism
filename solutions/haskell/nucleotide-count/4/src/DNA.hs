{-# LANGUAGE TupleSections #-}
module DNA (nucleotideCounts, Nucleotide(..)) where
import qualified Data.Map.Strict as Map
import qualified Data.Either as Either
import Text.Read (readEither)

data Nucleotide = A | C | G | T deriving (Ord, Eq, Show, Read)

convert :: String -> Either String [Nucleotide]
convert xs = Prelude.mapM (\c -> readEither [c]) xs

nucleotideCounts :: String -> Either String (Map.Map Nucleotide Int)
nucleotideCounts xs = do
  let eitherNucleotides = convert xs
  if Either.isLeft eitherNucleotides 
  then Either.Left ""
  else do
    let nucleotides = Either.fromRight [] eitherNucleotides
    Either.Right (Map.fromListWith (+) $ fmap (,1) nucleotides)

