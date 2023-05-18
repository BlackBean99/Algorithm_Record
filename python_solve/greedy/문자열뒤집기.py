# 315페이지
data = input()

#  0을 1로 바꾸는 경우
count0 = 0
#  1을 9으로 바꾸는 경우
count1 = 0

# 시작케이스는 어떻게?
if data[0] == '0':
    count0 += 1
else:
    count1 += 1

for i in range(len(data)-1):
    if data[i] != data[i+1]:
        #  1을 만나, 1을 0으로 바꾸는 경우
        if data[i] == '0':
            count1 += 1
            # 이제 0을 만나면 pass
        else:
            count0 += 1
print(count0, count1)
print(min(count0,count1))
