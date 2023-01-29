count = int(input())
test_case = []
total_score = 0 
score = 0

for i in  range(count):
    test = input()
    test_case.append(test)

for i in test_case:
    for j in i:
        if j == 'O':
            score = score +1
            total_score = total_score + score
        if j == 'X':
            score = 0
    print(total_score)
    score=0
    total_score=0