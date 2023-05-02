n = int(input())

values = list(map(int, input().split()))

dp = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if values[i] > values[j]:
            dp[i] = max(dp[i], dp[j] + 1)
print(dp[n-1])