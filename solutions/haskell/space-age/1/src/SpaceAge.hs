module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune

ageOn :: Planet -> Float -> Float
ageOn Earth seconds = seconds / 31555695.8031
ageOn Mercury seconds = seconds / 7600525.80461
ageOn Venus seconds = seconds / 19411026.1759
ageOn Mars seconds = seconds / 59359776.7898
ageOn Jupiter seconds = seconds / 374222565.145
ageOn Saturn seconds = seconds / 928792569.659
ageOn Uranus seconds = seconds / 2652994591.74
ageOn Neptune seconds = seconds / 5196280668.35
ageOn planet seconds = 100