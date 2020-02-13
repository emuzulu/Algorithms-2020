import numpy as np
def fib_exp(k):
    if not k or k==1:
        return k
    return fib_exp(k-1)+fib_exp(k-2)
def fib_lin(k):
    l0,l1=0,1
    for i in range(2,k+1):
        n0=l1
        n1=l1+l0
        l0=n0
        l1=n1
    return l1

def fib_log(k):
    A = np.array([[0,1],[1,1]], dtype='uint64')
    def find_A_to_k(k):
        if k==1:
            return A
        B = find_A_to_k(k//2) # as we can find A^k by finding (A^(k/2))^2
        if not k%2:
            return B@B  # even case
        return A@B@B #odd case
    base_case = np.array([0,1],dtype='uint64')
    return (find_A_to_k(k-1)@base_case)[1]