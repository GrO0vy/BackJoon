total =int(input())
count = int(input())
result = int(0)
for i in range(count):
    price,cnt = map(int, input().split())
    result = result + price*cnt
if result == total :
    print("Yes")
else:
    print("No")