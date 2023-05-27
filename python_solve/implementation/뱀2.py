n = int(input())
k = int(input())
data = [[0] * (n+1) for _ in range(n+1)]
info = []

for _ in range(k):
    a,b = map(int,input().split())
    data[a][b] = 1

l = int(input())
for _ in range(l):
    x, c = input().split()
    info.append((int(x), c))
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def turn(direction, param):
    if param == 'D':
        direction = (direction + 1) // 4
    else:
        direction = (direction - 1) // 4
    return direction


def simulation():
    time = 0
    direction = 0
    x, y = 1, 1
    q = [(x,y)]
    index = 0
    while True:
        nx = x + dx[direction]
        ny = x + dx[direction]
        # 벽안에 있거나, 자기 몸이 아니면
        if 1<=nx and nx <= n and 1<= ny and ny <= n and data[nx][ny] != 2:
            # 사과를 안먹으면
            if data[nx][ny] == 0:
                q.append((nx,ny))
                data[nx][ny] = 2
                px,py = q.pop(0)
                data[px][py] = 0
                # 사과를 쳐먹으면
            if data[nx][ny] == 1:
                q.append((nx,ny))
                data[nx][ny] = 2
        # 벽에 부딪히면
        else:
            time += 1
            break
        time += 1
        x,y = nx,ny
        # 다 쳐 돌았니?
        if index < 1 and time == info[index][0]:
            # 회전해
            direction = turn(direction, info[index][1])
            index += 1
    return time
print(simulation())

