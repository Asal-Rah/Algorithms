#function
def practice(a):
	length = len(a)
	assert(length >= 1)
	if length > 2:
		h = length // 2
		sec1 = a[:h]
		sec2 = a[h:]
		results = []
		results.append(sec1[:])
		a = practice(sec1)
		b = practice(sec2)

		length_of_a = len(a)
		length_of_b = len(b)
		assert (length_of_a == length_of_b or length_of_a == length_of_b - 1)
		for i in range(length_of_a):
			results.append(a[i] + b[i])
		if length_of_a == length_of_b - 1:
			results.append(a[0] + b[-1])
		return results

	else:
		return [[a[0]]]


#main
#input
n = int(input())
ans = [int(i) for i in range(1, n + 1)]
prac = practice(ans)
print(str(len(prac)))
for i in reversed(prac):
    print(str(len(i)), end="")
    for j in i:
        print(' ' + str(j), end="")
    print("")
