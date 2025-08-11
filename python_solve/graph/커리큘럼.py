# 위상정렬
from collections import deque
import copy

v = int(input())
indegree = [0] * (v+1)
graph = [[] for i in range(v+1)]
time = [0] * (v+1)

cost = [0] * (v+1)
for i in range(1, v+1):
    data = list(map(int, input().split()))
    time[i] = data[0]
    for x in data[1:-1]:
        indegree[i] += 1
        graph[x].append(i)

# 위상 정렬 함수
def topology_sort():
    result = copy.deepcopy(time)
    q = deque()
    #  진입차수가 0인 노드를 큐에 삽입
    for i in range(1,v+1):
        if indegree[i] == 0:
            q.append(i)
    #   큐가 빌때까지
    while(q):
        now = q.popleft()
        # 서 인접한 노드들의 indegree -1
        for i in graph[now]:
            result[i] = max(result[i], result[now] + time[i])
            indegree[i] -= 1
            # 새롭게 진입차수가 0인 노드를 큐에 삽입
            if indegree[i] == 0:
                q.append(i)
    for i in range(1,v+1):
        print(result[i])
topology_sort()
