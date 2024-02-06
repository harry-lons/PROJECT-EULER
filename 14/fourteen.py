'''
PROJECT EULER #14 : Longest Collatz Sequence
https://projecteuler.net/problem=14

Status: SOLVED , solution = 837799
'''

'''
Iterative approach
'''
global highterm
highterm = 0
global highdx
highdx = 0
i = 1
while(i < 1000000):
    print("i = " + str(i) + "\n")
    n = i
    numterms = 0
    while(n != 1):
        numterms = numterms + 1
        if(n%2 == 0):
            n = n/2
        else:
            n = 3*n + 1
    if(numterms > highterm):
        highterm = numterms
        print("new highterm: " + str(highterm) + '\n')
        highdx = i

    i += 1


'''
Recursive approach (doesn't work, exceeds maximum recursion depth)

numterms = 0
highterm = 0
def getterms(n): 
    global numterms
    numterms = numterms + 1
    if(n == 1):
        return
    else:
        if(n % 2 == 0):
            next_val = n/2
        else:
            next_val = 3*n + 1
        getterms(next_val)


for i in range(1000000) :
    numterms = 0
    getterms(i)
    if(numterms > highterm ):
        highterm = numterms
'''
print(highterm)
print(highdx)