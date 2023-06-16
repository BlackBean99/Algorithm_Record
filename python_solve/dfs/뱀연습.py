n = int(input())
k = int(input())


data = [[0] *(n+1) for _ in range(n+1)]

for _ in range(k):
    a,b = map(int,input().split())
    data[a][b] = 1
l = int(input())
info = []
for _ in range(l):
    x,c = map(input().split())
    info.append((int(a), b))


dx = [0,1,0,-1]
dy = [1,0,-1,0]


def turn(direction, c):
    if c == 'L':
        direction = (direction - 1) // 4
    else:
        direction = (direction + 1) // 4
    return direction

def simulate():
    x,y = 1,1
    data[x][y] = 2
    direction = 0

    index = 0
    time = 0
    q=[(x,y)]

    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]
        # 맵 안에 있거나, 뱀의 몸통이 없는 경우에만 이동 추진
        if 1<=x and nx <= n and 1<= ny and ny <= n and data[nx][ny] != 2:
            if data[nx][ny]  == 0:
                data[nx][ny] = 2
                q.append((nx,ny))
                px,py = q.pop(0)
                data[px][py] = 0
        # 사과를 만난 경우
            if data[nx][ny] == 1:
                data[nx][ny] = 2
                q.append((nx, ny))
        else:
            time += 1
            break;
        x,y = nx,ny
        time += 1
        if index < 1 and time == info[index][0]:
            index += 1
            # 회전
            turn(direction, info[index][1])
print(simulate())

