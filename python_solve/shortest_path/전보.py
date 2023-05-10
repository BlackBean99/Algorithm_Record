n,m,c = map(int,input().split())
# 2차원 리스트 초기화
INF = int(1e9)
graph = [[INF] * (n+1) for _ in range(n+1)]
# c -> 받는 도시의 총 개수, 걸리는 시간

for a in range(n + 1):
    for b in range(n + 1):
        if a == b:
            graph[a][b] = 0
            graph[b][a] = 0

for _ in range(m):
    x,y,z = map(int,input().split())
    graph[x][y] = z

for k in range(1,n+1):
    for a in range(1,n + 1):
        for b in range(1,n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

distance = 0
city_count = 0

for i in range(2, n+1):
    if graph[1][i] != INF:
        distance = max(graph[1][i], distance)
        city_count += 1

print(city_count, end = " ")
print(distance)