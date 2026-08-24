module LuciansLusciousLasagna exposing (elapsedTimeInMinutes, expectedMinutesInOven, preparationTimeInMinutes)

expectedMinutesInOven = 40

preparationTimeInMinutes layers_count = 2 * layers_count

elapsedTimeInMinutes layers_count elapsed = preparationTimeInMinutes(layers_count) + elapsed

