import sys
from collections import deque
n, m = map(int, input().split())

data = []
virus = []
distance = [[0] * n for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for i in range(m):
    row = list(map(int, input().split()))
    data.append(row)
    for j, val in enumerate(row):
        if val == 2:
            virus.append((i , j))
        elif val == 1:
            distance[i][j] = -1

def bfs():
    q = deque(virus)

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < m and 0 <= ny < n and data[nx][ny] != 1 and distance[nx][ny] == 0:
                distance[nx][ny] = distance[x][y] + 1
                q.append((nx, ny))

bfs()

def is_success():
    max_value = -1
    for i in range(m):
        for j in range(n):
            if distance[i][j] == 0 and data[i][j] == 0:
                return -1
            max_value = max(max_value, distance[i][j])
    return max_value

result = is_success()
print(result)
