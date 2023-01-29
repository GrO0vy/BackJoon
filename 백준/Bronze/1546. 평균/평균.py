count = int(input())
score = list(map(int, input().split()))
result=[]
for i in score:
    result.append(i/max(score)*100)

add = 0
for i in result:
    add=add+i

avg = add / count
print(avg)