# Small example of recursion based on algorithm from lecture 02/20

def recur_relat (n):
    if n == 0:
        return 2
    else:
        return 2 * recur_relat(n - 1)

print(recur_relat(8))