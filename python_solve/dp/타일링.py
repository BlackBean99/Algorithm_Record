n = int(input())

#  경우의수
#  1개를 채운다 1가지
#  가로로 박스를 만드는 2가지 경우의 수

# 5개를 하는 방법은?

d = [0] * 1001
d[1] = 1
d[2] = 3
# a[i-1] +1,
# a[i-2] * 2

for i in range(3, n + 1):
    d[i]= (d[i-1]+ 2 * d[i-2]) % 796796

# for i in range(3, n+1):
#     dp[i] = (dp[i-1] + dp[i-2] * 2) % 796796
# dp 뒤로 잡아보면 어떨까?
print(d[n])
# for i in range(n,0,-1):