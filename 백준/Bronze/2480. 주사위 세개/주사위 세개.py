n1,n2,n3 = map(int, input().split())
numbers = [n1,n2,n3]
numbers.sort()
if numbers[0]==numbers[1] and numbers[1]==numbers[2] :
    print(10000+n1*1000)
elif n1!=n2 and n1!=n3 and n2!=n3:
    print(100*numbers[2])
else:
    print(1000+100*numbers[1])