# A(1번회사) -> X -> K
n,m = map(int,input().split())
INF = int(1e9)
# distance = [[INF] * (m+1)] * (m+1)
distance = [[INF] * (n+1) for _ in range(n+1)]
start = 1
# 이동 비용을 출력한다

for a in range(1, n+1):
    for b in range(1,n+1):
        if a==b:
            distance[a][b] = 0

for _ in range(m):
    a,b = map(int, input().split())
    distance[a][b] = 1
    distance[b][a] = 1

x,k = map(int,input().split())

# dijkstra(1)
# print_array(distance)

for k in range(1,n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])

distance = distance[1][k] + distance[k][x]

if distance >= INF:
    print("-1")
else:
    print(distance)