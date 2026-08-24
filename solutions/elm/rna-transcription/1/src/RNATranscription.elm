module RNATranscription exposing (toRNA)


toRNA : String -> Result Char String
toRNA dna =
    if String.isEmpty dna then
        Err 'X'

    else
        Ok (String.join "" (List.map toSingleRNA (String.split "" dna)))


toSingleRNA : String -> String
toSingleRNA dna =
    case dna of
        "C" ->
            "G"

        "G" ->
            "C"

        "T" ->
            "A"

        "A" ->
            "U"

        _ ->
            ""
