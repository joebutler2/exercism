import functools


def square_of_sum(number):
    return functools.reduce(lambda x, y: x + y, range(0, number + 1), 0) ** 2


def sum_of_squares(number):
    return functools.reduce(lambda x, y: x + y ** 2, range(0, number + 1), 0)


def difference_of_squares(number):
    return square_of_sum(number) - sum_of_squares(number)
