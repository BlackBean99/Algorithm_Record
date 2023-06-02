from collections import deque

n,l,r = map(int,input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

# 두개의 나라를 합쳐서
# 합친 수 / 연합 개수 로 변경
dx = [1,0,-1,0]
dy = [0,1,0,-1]

result = 0

def process(x,y,index):
    # (x,y)의 위치와 연결된 연합 정보를 담는 리스트
    united = []
    united.append((x,y))

    q = deque()
    q.append((x,y))
    union[x][y] = index
    summary = graph[x][y] # 현재 연합의 번호 할당
    count = 1 # 현재 연합의 국가 수
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx and nx < n and 0 <= ny and ny < n and union[nx][ny] == -1:
                if 1<= abs(graph[nx][ny] - graph[x][y]) <= r:
                    q.append((nx,ny))
                    union[nx][ny]  = index
                    summary += graph[nx][ny]
                    count += 1
                    united.append((nx,ny))
    for i, j in united:
        graph[i][j] = summary // count
    return count

total_count = 0

while True:
    union = [[-1] * n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j] == -1:
                process(i,j,index)
                index += 1
    if index == n*n:
        break
    total_count += 1