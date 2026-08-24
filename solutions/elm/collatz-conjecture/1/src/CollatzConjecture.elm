module CollatzConjecture exposing (collatz)


collatz : Int -> Result String Int
collatz start =
    let
        count_step num steps =
            let
                is_even =
                    modBy 2 num == 0
            in
            if num <= 1 then
                Ok steps

            else
                let
                    next_num =
                        if is_even then
                            num // 2

                        else
                            num * 3 + 1
                in
                count_step next_num (steps + 1)
    in
    if start > 0 then
        count_step start 0

    else
        Err "Only positive numbers are allowed"
