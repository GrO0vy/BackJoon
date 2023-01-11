count = int(input())
elements = input().split()
target = int(input())
result=0 
for i in range(count):
    if int(elements[i])==target:
        result+=1  
print(result)
