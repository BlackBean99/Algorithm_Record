n = int(input())

dp = [0] * 30001
# 초기값 세팅
dp[1] = 0
dp[2] = 1
for i in range(3,n+1):
    i
    if i % 5 == 0:
        dp[i] = min(dp[int(i/5)],dp[i-1]) + 1
    elif i % 3 == 0:
        dp[i] = min(dp[int(i/3)],dp[i-1]) + 1
    elif i % 2 == 0:
        dp[i] = min(dp[int(i/2)], dp[i-1]) + 1
    else:
        dp[i] = dp[i-1] + 1
print(dp[n])