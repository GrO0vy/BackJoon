count = int(input())
elements = input().split()
max = -1000001
min = 1000001
for i in range(count):
    if int(elements[i]) > max:
        max = int(elements[i])
    if int(elements[i]) < min :
        min = int(elements[i])
print(min,max)
