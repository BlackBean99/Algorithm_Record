import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())
start = int(input())
graph = [[] for i in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    graph[a].append((b, c))

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    # 힙 시작 초기화
    distance[start] = 0
    # 큐가 비어있지 않다면
    while q:
        #가장 최단 거리가 짧은 노드를 꺼내서
        dist, now = heapq.heappop(q)
        # 현재 값이 최단 거리가 아닌 경우
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 방문한 노드가 이전 저장된 cost보다 작을 경우
            if cost < distance[i[0]]:
                # 교체하기
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))
dijkstra(start)

for i in range(1,n+1):
    # 도달할 수 없는 경우, 무한이라고 출력
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])
