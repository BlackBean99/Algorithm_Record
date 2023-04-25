from collections import deque

nx, ny = 1, 1
n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 괴물은 0, 없으면 1
# 1로 움직여야한다
# n,m 으로 가기 위한 최소한의 칸의 개수
# dfs로 구현 하면서 depth가 얼마나 깊어지는지 계산하기
# 이전 기록에 대한 정보가 필요한가? yes : 재귀가 아닌 반복문을 활용한 queue 를 호출하자
dx = [1, 0, -1, 0]
dy = [0, 1, -1, 0]

def bfs(x,y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #  범위를 나갔을 경우에
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            #  벽일 경우 무시
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] +1
                queue.append((nx, ny))
    return graph[n-1][m-1]

print(bfs(0,0))



