from collections import deque

n, k = map(int,input().split())

graph = [] # 위치 정보
data = [] # 바이러스 정보
for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(n):
        # 바이러스가 아니라면
        if graph[i][j] != 0:
            # virus 종류, time
            data.append((graph[i][j],0,i,j))

data.sort()
q = deque(data)

target_s,target_x,target_y = map(int,input().split())

dx = [-1,0,1,0]
dy = [0,1,0,-1]

while q:
    virus, s,x,y = q.popleft()
    # 종료 조건
    if s == target_s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx <= 0 and nx < n and ny <= 0 and ny < n:
#             아직 방문하지 않으면 바이러스 삽입
            if graph[nx][ny] != 0:
                graph[nx][ny] = virus
                q.append(virus, s+1, nx,ny)


