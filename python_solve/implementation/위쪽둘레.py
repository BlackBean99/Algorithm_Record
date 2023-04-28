import sys

n = int(input())

dp = [[0]*2 for _ in range(n+1)]
arr = [[0]*2 for _ in range(n+1)]

arr[1] = dp[1] = list(map(int, sys.stdin.readline().split()))

for i in range(2, n+1):
    arr[i] = list(map(int, sys.stdin.readline().split()))
    dp[i][0] = arr[i][0] + max(dp[i-1][0] + abs(arr[i-1][1] - arr[i][1]), dp[i-1][1] + abs(arr[i-1][0] - arr[i][1]))
    dp[i][1] = arr[i][1] + max(dp[i-1][0] + abs(arr[i-1][1] - arr[i][0]), dp[i-1][1] + abs(arr[i-1][0] - arr[i][0]))

print(max(dp[n]))