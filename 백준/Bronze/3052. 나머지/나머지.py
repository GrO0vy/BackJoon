numbers =[]
for i in range(10):
    number = int(input())
    numbers.append(number%42)

result = set(numbers)
print(len(result))