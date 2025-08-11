from itertools import combinations

n,m = map(int,input().split())

data = []
space = []
for i in range(n):
    data.append(list(map(int, input().split())))
    for j in range(m):
        if data[i][j] == 0:
            space.append((i,j))

#  벽을 3개 세울 수 있다.
# 0 빈칸, 1 벽, 2 바이러스

# spread 함수가 필요하다. dfs virus

# def process():

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def virus(x,y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 < nx < n and 0 < ny < m:
            if new_data[nx][ny] == 0:
                # 감염
                new_data[nx][ny] = 1
                virus(nx, ny)

def get_count(map):
    count = 0
    for i in range(n):
        for j in range(m):
            if map[i][j] == 0:
                count += 1
    return count


# 기존의 맵
# 벽이 세워진 맵
new_data = data
answer = 0
#
for walls in combinations(space,3):

# #     벽 3개를 골라서 data 에 담았다.
    for x,y in walls:
#
        # 벽 3개 설치
        new_data[x][y] = 1
#     # 새로운 벽으로 시뮬레이션을 해보자
#         0이 아닌 자리 찾기
        start_x = 0
        start_y = 0
        for i in range(n):
            for j in range(m):
                if new_data[i][j] != 0:
                    continue
                else:
                    start_x = i
                    start_y = j
        virus(start_x,start_y)
        answer = max(answer,get_count(new_data))
        new_data = data
#
print(answer)
