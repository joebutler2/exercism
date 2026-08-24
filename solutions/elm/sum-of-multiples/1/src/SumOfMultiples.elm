module SumOfMultiples exposing (findMultiples, sumOfMultiples)


sumOfMultiples : List Int -> Int -> Int
sumOfMultiples divisors limit =
    List.foldl
        (\divisor acc -> acc + findMultiples divisor limit)
        0
        divisors


findMultiples : Int -> Int -> Int
findMultiples divisor limit =
    let
        multiples cur_value accum =
            if cur_value >= limit then
                accum

            else
                let
                    nextValue =
                        cur_value + divisor
                in
                multiples nextValue accum + cur_value
    in
    multiples divisor 0
