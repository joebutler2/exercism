module DNA (nucleotideCounts) where

import Data.Map (Map,adjust, fromList)


countOfElem elem list = length $ filter (\x -> x == elem) list
nucleotides = ['A', 'C', 'G', 'T']
invalidChars = filter (\s -> s `notElem` nucleotides) ['A'..'Z']

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts xs = do
    let aCount = countOfElem 'A' xs
    let cCount = countOfElem 'C' xs
    let gCount = countOfElem 'G' xs
    let tCount = countOfElem 'T' xs
    let theMap = fromList([('A', aCount), ('C', cCount), ('G', gCount), ('T', tCount)])

    if any (\s -> s `elem` invalidChars) xs
    then Left ""
    else Right theMap

-- Attempted solution in which you would iterate over the input string
-- and form a hash based on it.
--     let baseMap = fromList [ ('A', 0), ('C', 0), ('G', 0), ('T', 0) ]
--     map (\s -> (adjust (1 +) s baseMap)) xs
