# 1 <= n <=30
n = int(input())
# 가로줄의 길이
# 3 X n 크기의 타일 채우기
# 무조건 2의 배수를 줄 수밖에 없다.
# i =
# i-1 = (i-2) + 1
dp = [0 for _ in range(n+1)]
for i in range(1,n+1):
    if i % 2 == 1:
        continue
    else:
        dp[i] = dp[i-2] * 3
print(n)