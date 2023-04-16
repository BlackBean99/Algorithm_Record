n,m = map(int, input().split())
k = []
for i in range(n):
    l = list(map(int, input().split()))
    k.append(l)
minValue = 0
for i in range(n):
    tempMin = 101
    for j in range(m):
        tempMin = min(tempMin,k[i][j])
    minValue = max(tempMin,minValue)

print(minValue)


