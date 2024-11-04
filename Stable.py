def search_for_min(boards, cows , arr):

    a = []
    arr = sorted(arr)
    for i in range(1, cows):
        a.append(arr[i] - arr[i-1] - 1)
    a=sorted(a, reverse=True)
    total_amount = 1 + arr[-1] - arr[0]
    minimum = min(boards - 1, cows - 1)
    i = 0
    while (minimum > 0):
        total_amount = total_amount - a[i]
        minimum = minimum - 1
        i = i + 1

    return total_amount
#get the inputs from user
maximum , trough , cows = map(int, input().split())
stalls = []
i = 0
#other inputs
while ( i < cows ):
    stalls.append(int(input()))
    i = i + 1
answer = search_for_min(maximum , cows , stalls)
#print the output
print(answer)