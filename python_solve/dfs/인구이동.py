n,l,r = map(int,input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

# 두개의 나라를 합쳐서
# 합친 수 / 연합 개수 로 변경
dx = [1,0,-1,0]
dy = [0,1,0,-1]

count = 0

x,y = 0,0
for i in range(n):
    for j in range(n):
        x, y = i,j
        for i in range(4):
            nx = x + dx[i]
            ny = y +dy[i]
            if nx <= 0 and nx < n and ny <= 0 and ny < n:
                if abs(graph[x][y] - graph[nx][ny]) >= l and abs(graph[x][y] - graph[nx][ny]) <= r:
                    graph[x][y] = (graph[x][y] + graph[nx][ny]) // 2
                    graph[nx][ny] = (graph[x][y] + graph[nx][ny]) // 2
                    count += 1

print(count)
