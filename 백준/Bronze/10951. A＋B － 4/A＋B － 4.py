import sys
while True :
    line =sys.stdin.readline()
    if line == "":
        break
    n1 , n2  = map(int , line.split())
    print(n1+n2)
