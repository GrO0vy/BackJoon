numbers = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
students = []
for i in range(28):
    number = int(input())
    students.append(number)

for i in students:
    numbers.remove(i)

print(numbers[0])
print(numbers[1])