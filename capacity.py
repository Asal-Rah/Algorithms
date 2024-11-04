#define needed variable
arr = []
i = 0
#define a list for opened boxes
box = []
#get the inputs from user
x,y = map(int, input().split())

while ( i < y):
    a,b = map(int, input().split())
    arr.append((10 ** a, b, i + 1))
    i = i + 1
#sort the array in reverse
arr = sorted(arr , reverse=True)
#swap the values
temp = arr[y-1]
arr[y-1]= arr[y-2]
arr[y-2] = temp
for i, j, n in arr:
    if x >= i:
        t = min((x // i), j)
        x = x - t * i
        box.append(n)
#print the results
if x <= 0 :

    # minimum amount of opened boxes
    print(len(box))
    # number of the boxes that have been opened
    for i in range(len(box)):
        print(box[i], end=' ')


else:
    print("-1")

