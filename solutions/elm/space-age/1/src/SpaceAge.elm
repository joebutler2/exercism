module SpaceAge exposing (Planet(..), ageOn)


type Planet
    = Mercury
    | Venus
    | Earth
    | Mars
    | Jupiter
    | Saturn
    | Uranus
    | Neptune


numOfEarthSecondsInYear : Float
numOfEarthSecondsInYear =
    31557600


ageOn : Planet -> Float -> Float
ageOn planet seconds =
    let
        earthYears =
            seconds / numOfEarthSecondsInYear
    in
    case planet of
        Earth ->
            earthYears

        Venus ->
            earthYears / 0.61519726

        Mars ->
            earthYears / 1.8808158

        Jupiter ->
            earthYears / 11.862615

        Saturn ->
            earthYears / 29.447498

        Uranus ->
            earthYears / 84.016846

        Neptune ->
            earthYears / 164.79132

        Mercury ->
            earthYears / 0.2408467
