module Leap exposing (isLeapYear)


isLeapYear : Int -> Bool
isLeapYear year =
    if remainderBy 400 year == 0 then
        True

    else if remainderBy 100 year == 0 then
        False

    else
        remainderBy 4 year == 0
