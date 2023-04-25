from collections import deque

n, m = map(int, input().split())
graph = []
result = 0

for i in range(n):
    graph.append(list(map(int, input())))


def dfs(x, y):
    # 경계를 넘어 가거나 이미 방문한 노드면 방문 하지 않는다.
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        # 상, 하, 좌, 우 재귀 호출
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False


for i in range(n):
    for j in range(m):
        if dfs(i, j):
            result += 1
print(result)
