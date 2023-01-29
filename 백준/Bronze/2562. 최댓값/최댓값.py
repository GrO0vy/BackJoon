num = 0
array = []
max = 0
min = 100
index = 0

for i in range(9):
    num = int(input())
    array.append(num)
    
for i,j in zip(array,range(1,10)):
    if i>max:
        max = i
        index =j 
    if i<min :
        min = i
        
print(max)
print(index)
    