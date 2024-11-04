
def main():
    A = sorted([int(i) for i in input().split()])
    n = 0

    step = min(A[1] - A[0], A[2] - A[1])
    A[2] -= 2 * step
    A[1] -= step
    n += step

    if A[2] - A[0] < 2:
        return n + A[0]
    
    if A[2] == A[1]:
        k = A[1] - A[0]
        step = k // 3 * 2
        if k % 3 > 1:
            step += 1
        return n + step + A[0]

    if A[2] >= 3*A[0]:
        return n + A[0]*2
    k = A[2] - A[0]
    step = k // 3 * 2
    A[0] -= step // 2
    return n + A[0] + step

    



print(main())