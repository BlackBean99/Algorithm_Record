n = int(input())

values = list(map(int,input().split()))
dp = values

for i in range(3,n):
    dp[i] = max(dp[i] + dp[i-2],dp[i] + dp[i-3])
print(dp[3])