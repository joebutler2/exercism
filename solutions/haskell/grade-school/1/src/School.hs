module School (School, add, empty, grade, sorted) where
import Data.List (find, insert, sortOn, sortBy, insertBy)
import Data.Map (Map, adjust)

type Student = String
type Grade = (Int, [Student])
type School = [Grade]

add :: Int -> Student -> School -> School
add gradeNum student school = do
  if hasGrade gradeNum school
  then map (\(g, xs) -> if g == gradeNum then (g, insert student xs) else (g, xs)) school 
  else insert (gradeNum, [student]) school 

hasGrade :: Int -> School -> Bool
hasGrade grade school = any (\(i, _) -> i == grade) school

empty :: School
empty = []

grade :: Int -> School -> [String]
grade gradeNum school = getStudents $ find (\(g, _) -> g == gradeNum) school

getStudents :: Maybe Grade -> [Student]
getStudents (Just (_, xs)) = xs
getStudents Nothing = []

sorted :: School -> [(Int, [String])]
sorted school = sortOn fst school

