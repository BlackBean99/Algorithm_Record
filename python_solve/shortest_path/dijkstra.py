import heapq
n,m = map(int,input().split())
start = int(input())
INF = int(1e9)
graph = []
distance = [INF] * (n+1)

for i in range(n):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

def dijkstra(start):
    q = []
    heapq.heappush(q, (start,0))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop()
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost, i[0]))