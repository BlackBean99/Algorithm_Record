# n = int(input())
# k = int(input())
#
# array = [[[0] * (n+1)] * (n+1)]
#
# for i in range(k):
#     a,b = map(int,input().split())
#     array[a][b] = 1
# L = int(input())
#
# dir_info = [0] * 10000
# for i in range(L):
#     a,b = map(int,input().split())
#     dir_info[a] = b
#
# # L은 왼쪽, D 는 오른쪽 방향 전환
# # isGameOver()
# body = [[1,1]]
#
# def check(nx,ny):
#
#
# dx = [1,0,-1,0]
# dy = [0,-1, 0,1]
# while True:
#     second = 0
#     cur = [1,1]
#     current_dir = 0
#     # 방향 전환 정보가 없으면
#     if dir_info[second] == 0:
#         # 움직일 위치 계산
#         nx = cur[0] + dx[current_dir]
#         ny = cur[1] + dy[current_dir]
#     #     현재 방향으로 직진
#     #     벽에 만나면
#         if nx < 0 or nx >= n or ny < 0 or ny >= n:
#             print(second)
#         # 뱀의 몸이랑 만나면
#         else if check(nx,ny):
#
#         # 뱀이 사과를 먹으면
#         # 사과 위치로 cur 이동
#         # body 에 한칸 연장
#         cur[0] += dx[current_dir]
#         cur[1] += dy[current_dir]
#
#
#     # i+1, j-1, i-1,j+1


n = int(input())
k = int(input())
data= [[0]*(n+1) for _ in range(n+1)] #업 정보
info = [] # 방향 회전 정보

# 맵 정보(사과 있는 곳은 1로 표시)
for _ in range(k):
    a, b = map(int, input().split())
    data[a][b] = 1
# 방향 회전 정보 입력
l = int(input())
for _ in range(l):
    x, c = input().split()
    info.append((int(x), c))
# 처음에는 오른쪽을 보고 있으므로(동/ 남/ 서/ 북)
dx =[0, 1, 0, -1]
dy = [1, 0, -1, 0]


def turn(direction, c):
    if c == "L":
        direction (direction -1) % 4
    else:
        direction = (direction + 1) % 4
    return direction

def simulate():
    x,y = 1,1 # 뱀의 머리
    data[x][y] = 2 # 뱀이 존재하는 위치는 2로 표현
    direction = 0 # 처음에는 동쪽
    time = 0 # 시작한 뒤에 지난 시간 초
    index = 0 # 다음에 회전할 정보
    q =[(x,y)] # 뱀이 차지하고 있는 위치 정보
    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]
        # 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
        if 1 <= nx and nx <= n and 1 <= ny and ny <= n and data[nx][ny] != 2:
            # 사과가 없다면 이동후에 꼬리 제거
            if data[nx][ny] == 0:
                data[nx][ny] = 2
                q.append((nx,ny))
                px,py = q.pop(0)
                data[px][py] = 0
        # 사과가 있다면 이동 후에 꼬리 그대로 두기
            if data[nx][ny] == 1:
                data[nx][ny] = 2
                q.append((nx,ny))
        else:
            time += 1
            break
        # 다음칸으로 이동하고 나서
        x,y = nx,ny
        time += 1
        if index < 1 and time == info[index][0]: # 회전할 시간인 경우 회전
            direction = turn(direction, info[index][1])
            index += 1
    return time
print(simulate())