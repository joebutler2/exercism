module Gigasecond exposing (add)

import Time


add : Time.Posix -> Time.Posix
add timestamp =
    Time.millisToPosix (Time.posixToMillis timestamp + 1000000000000)
