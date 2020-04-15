module Bob exposing (hey)

import Regex
import String exposing (contains)


hey : String -> String
hey remark =
    let
        shoutingRegexComplex =
            Maybe.withDefault Regex.never <|
                Regex.fromString "^[A-Z,0-9!\\s%*@#\\$\\(*\\^]{2,}[!\\?]$"

        shoutingRegex =
            Maybe.withDefault Regex.never <|
                Regex.fromString "^[A-Z,\\s]+$"

        shoutingQuestionRegex =
            Maybe.withDefault Regex.never <|
                Regex.fromString "^([A-Z!]|\\s|)+\\?$"

        plainQuestion =
            Maybe.withDefault Regex.never <|
                Regex.fromString "\\?\\s*$"

        whitespace =
            Maybe.withDefault Regex.never <|
                Regex.fromString "^\\s*$"
    in
    if Regex.contains shoutingQuestionRegex remark then
        "Calm down, I know what I'm doing!"

    else if Regex.contains whitespace remark then
        "Fine. Be that way!"

    else if Regex.contains shoutingRegexComplex remark || Regex.contains shoutingRegex remark then
        "Whoa, chill out!"

    else if Regex.contains plainQuestion remark then
        "Sure."

    else
        "Whatever."
