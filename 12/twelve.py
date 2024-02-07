'''
    PROJECT EULER #12
https://projecteuler.net/problem=12

Status: SOLVED , solution = 76576500

Could solve this pretty quickly in java, but still working on my python familiarity 
so opting to use python for this one
'''

import sys as s
def getDivisors(n):
    # we only need to check up to the square root of n, and add two divisors each time we find one, as 
    # divisors come in pairs, with one divisor <√n and one >√n. Makes the algorithm much faster
    count = 0
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            if n / i == i:
                count += 1
            else:
                count += 2
    return count
        
max = 0
for idx in range(1,100000,1):
    # idx copy
    n = idx
    print("n = " + str(n) + "\n")

    # triangular number of n elements
    tri = (n*(n+1))/2
    divisors = getDivisors(tri)
    if(divisors >= 500):
        print(str(int(tri)) + " has " + str(divisors) + " divisors! We are done")
        if(divisors > max):
            max = divisors
        s.exit()
    print(str(int(tri)) + " has " + str(divisors) + " divisors!")
    if(divisors > max):
            max = divisors
    print("max = " + str(int(max)))

