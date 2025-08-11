n = int(input())
x,y = 1,1
plans = input().split()
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_type = ['L', 'R' 'U', 'D']

for plan in plans:
    for type in range(len(move_type)):
        if plan == move_type[type]:
            nx = x + dx[type]
            ny = y + dy[type]
    if nx < 1 or nx > n or ny < 1 or ny > n:
        continue
    x,y = nx,ny
print(x,y)