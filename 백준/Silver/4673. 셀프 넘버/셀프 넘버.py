no_self=[]
result = 0

for i in range(10001):
    result = i
    if i >= 10000:
        result = result + i//10000
        i = i%10000
    if i >= 1000:
        result = result + i//1000
        i = i%1000
    if i >= 100 :
        result = result + i//100
        i = i%100
    if i >= 10 :
        result = result + i//10 
        i = i%10
    result = result + i
    no_self.append(result)

for i in range(10001):
    if i not in no_self:
        print(i)