n1 , n2 = map(int, input().split())
n3 = int(input())
n2 = n2 + n3
if n2>=60:
    n1 = n1 + (n2//60)
    n2 = n2 % 60
if n1 >=24 :
    n1 = n1-24

print(n1 ,n2 )