from itertools import combinations

n = int(input())
board = []
teachers = []
spaces = []
for i in range(n):
    board.append(list(input().split()))
    for j in range(n):
        if board[i][j] == 'T':
            teachers.append((i,j))
        if board[i][j] == 'X':
            spaces.append((i,j))

def watch(x,y,direction):
    # 왼쪽 방향으로 감시
    if direction == 0:
        while y >= 0:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            y -= 1
    # 오른쪽으로 감시
    if direction == 1:
        while y < n:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            y += 1
    # 위쪽으로 감시
    if direction == 2:
        while x >= 0:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            x -= 1
        # 위쪽으로 감시
    if direction == 3:
        while x < n:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            x += 1
    return False

def process():
#      모든 선생님 하나하나 뒤져서
    for x,y in teachers:
        for i in range(4):
            if watch(x,y,i):
                return True
        # 모든 방향을 다 뒤져보면
        return False
    find = False
    for data in combinations(spaces, 3):
        # 재귀전 행동
        for x,y in data:
            # 벽 세우기
            board[x][y] = 'O'

        if not process():
            find = True
            break
        # 재귀 후 행동 ( 백트래킹 )
        for x,y in data:
            board[x][y] = 'X'
    if find:
        print("Yes")
    else:
        print("NO")



