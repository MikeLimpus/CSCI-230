# Recursive implementaion to calculate fibonacci numbers
import time
start_time = time.time()

def fibonacci(n):
    if n == 0:
        return 0
        # print(fibonacci(n)) 
    elif n == 1:
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)    

print(fibonacci(47))
print(round((time.time() - start_time)))