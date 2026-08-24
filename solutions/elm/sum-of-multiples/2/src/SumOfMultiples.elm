module SumOfMultiples exposing (sumOfMultiples)

import Set exposing (Set)


sumOfMultiples : List Int -> Int -> Int
sumOfMultiples divisors limit =
    divisors
        |> List.concatMap (\divisor -> findMultiples divisor limit)
        |> Set.fromList
        |> Set.toList
        |> List.foldl (+) 0


findMultiples : Int -> Int -> List Int
findMultiples divisor limit =
    let
        multiples cur_value accum values =
            if cur_value >= limit then
                values

            else
                let
                    nextValue =
                        cur_value + divisor
                in
                multiples nextValue (accum + cur_value) (cur_value :: values)
    in
    multiples divisor 0 []
