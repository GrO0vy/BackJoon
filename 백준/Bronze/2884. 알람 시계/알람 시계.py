n1 , n2 = map(int , input().split())
if n2 < 45 :
    if n1 == 0 : 
        n1 = 23
    else:
        n1 = n1 -1
    n2 = 60 -(45 -n2)
else :
    n2 = n2 -45

print(n1 , n2)