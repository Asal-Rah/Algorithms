#River
#get inputs from user
x,y,t = map(int,input().split())
arr = list(map(int,input().split()))
#define arrays
sum_of_arr=sum(arr)
summ=[]
answer=[]
if (x - sum_of_arr) / (y + 1) > t - 1:
	print("NO")
	exit()

for i in arr:
	summ.append(sum_of_arr)
	sum_of_arr = sum_of_arr + i

t = t - 1
s = sum(arr)
sum_of_arr = x - s

for j in range(y):
	if sum_of_arr >= t:
		answer =answer + [0]*t + [j+1]*arr[j]
		sum_of_arr = sum_of_arr - t
	else :
		answer = answer + [0]*sum_of_arr+[j+1]*arr[j]
		sum_of_arr=0


answer = answer + [0]*sum_of_arr
#print the output
print("YES")
print(*answer)
