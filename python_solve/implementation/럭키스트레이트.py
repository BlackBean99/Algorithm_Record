# /2
# 왼쪽 합, 오른쪽 합이 동일한 상황
# 123,402
str = input()
mid = int(len(str)/2) -1
left_sum = 0
right_sum = 0

# 왼쪽 합 구하기
for i in range(mid+1):
    left_sum += int(str[i])
    right_sum += int(str[i+mid+1])
if left_sum == right_sum:
    print("LUCKY")
else:
    print("READY")
