'''
Recursively calculate the n power of any number with
O(log n) complexity
'''


def power(x, n):
    # input x and int n
    # output x^n
    if n == 0:
        return 1
    elif n % 2 == 1:
        y = pow(x, (n-1/2))
        return x * y * y
    else:
        y = pow(x, n/2)
        return y * y
