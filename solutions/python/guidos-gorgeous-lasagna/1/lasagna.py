"""Functions used in preparing Guido's gorgeous lasagna.

Learn about Guido, the creator of the Python language: https://en.wikipedia.org/wiki/Guido_van_Rossum
"""

EXPECTED_BAKE_TIME = 40
PREPARATION_TIME = 2


def bake_time_remaining(elapsed_time):
    """Calculate the time remaining in the lasagna bake."""
    return EXPECTED_BAKE_TIME - elapsed_time


def preparation_time_in_minutes(layers_count):
    """Calculate the time required to prepare the lasagna."""
    return layers_count * PREPARATION_TIME


def elapsed_time_in_minutes(layer_count, elapsed_time):
    """Calculate the time elapsed since the lasagna was prepared."""
    return layer_count * PREPARATION_TIME + elapsed_time
