def choose(n,r): 
    # If n < r, choose is invalid. If n == r, nCr = 1
    if n <= r : return 0
    result = 1.0
    nr = n - r
    while n >= 1:
        if result >= 1000000 : break
        result *= n
        result /= r
        result /= nr
        if r != 1 : r -= 1
        if nr != 1 : nr -= 1
        n -= 1
    if result > 1000000 : return 1
    else : return 0
    
ct = 0
for n in range(1,101):
    for r in range(1,n):
        ct += choose(n,r)
print(ct)