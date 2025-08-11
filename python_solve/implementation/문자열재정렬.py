str = input()

digit = []
alpha = []
sum = 0
for i in range(len(str)):
    if str[i].isalpha():
        alpha.append(str[i])
    else:
        digit.append(int(str[i]))
        sum+= int(str[i])
alpha.sort()
alpha.append(sum)
for i in range(len(alpha)):
    print(alpha[i], end='')
