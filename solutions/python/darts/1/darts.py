from math import sqrt

def score(x, y):
    hyp = sqrt(x**2 + y**2)
    print(hyp)
    match hyp:
        case _ if hyp > 10:
            return 0
        case _ if 5 < hyp <= 10:
            return 1
        case _ if 1 < hyp <= 5:
            return 5
        case _:
            return 10
        
