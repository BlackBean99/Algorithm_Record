from collections import deque

m, n = map(int, input().split())

data = []
tomato = []
for i in range(n):
    data.append(list(map(int, input().split())))
    for j in range(m):
        if data[i][j] == 1:
            tomato.append((j, i))

visit = [[0] * m for _ in range(n)]
day = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def get_max(new_loc):
    max_value = 0
    for i in range(n):
        for j in range(m):
            max_value = max(max_value, new_loc[i][j])
    return max_value


def is_full(new_loc):
    for i in range(n):
        for j in range(m):
            if new_loc[i][j] == 0:
                return False
    return True


q = deque()
for x, y in tomato:
    q.append((x, y))

while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < m and 0 <= ny < n:
            if visit[ny][nx] == 1:
                continue
            if data[ny][nx] == -1:
                visit[ny][nx] = 1
                continue
            if data[ny][nx] == 0:
                data[ny][nx] = data[y][x] + 1
                visit[ny][nx] = 1
                q.append((nx, ny))
            # else:
            #     data[ny][nx] = min(data[y][x] + 1, data[ny][nx])
            #     visit[ny][nx] = 1
            #     q.append((nx, ny))

if is_full(data):
    # 시작 날짜가 0이기 때문이다.
    print(get_max(data)-1)
else:
    print(-1)
