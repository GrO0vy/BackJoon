n = int(input())
a = n
count = 0

while True:
    if a < 10:
        a = 11*a
    else:
        a = (a%10)*10 + (a//10+a%10)%10
    count+=1
    if n==a :
        break
print(count)