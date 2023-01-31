count = int(input())

data = []
for i in range(count):
    test = list(map(int,input().split()))
    data.append(test) 
    
total = 0
avg = 0
more_avg = 0

for i in data:
    for j in range(1,i[0]+1):
        total = total + i[j]
    avg = total / i[0]
    for k in range(1,i[0]+1):
        if i[k] > avg:
            more_avg = more_avg + 1
    if more_avg ==0:
        print('0.000%')
    else:
        print('%0.3f' % round(float(more_avg)/i[0]*100,3)+'%')
    total =0
    avg =0
    more_avg=0