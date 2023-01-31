num = int(input())
result = 0 
for i in range(1,num+1):
    if i < 100:
        result = result + 1
    else :
        a1 = i//100
        a2 = i%100//10
        a3 = i%100%10
        if a1-a2 == a2-a3 : 
            result = result + 1
print(result)