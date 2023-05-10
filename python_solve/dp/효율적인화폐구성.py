n,m = map(int,input().split())
array = []
for i in range(n):
    array.append(int(input()))
# m원을 만들 수 있는 모든 경우의 수는?

dp = [10001] * 10000
# i원을 만들 수 있는 돈의 방법은?
# i원 - array[i] 방법들을 추가해보면 어떨까?

# 0 부터 m포함해서
dp[0] = 0

for i in range(n):
    for j in range(array[i],m+1):
        if dp[j- array[i]] != 10001:
            dp[j] = min(dp[j-array[i]] + 1, dp[j])
if dp[m] == 10001:
    print(-1)
else:
    print(dp[m])