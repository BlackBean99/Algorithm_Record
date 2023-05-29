from itertools import combinations

n = int(input())
board = [] # 복도 정보
teachers = [] # 모든 선생님 위치 정보
spaces = [] # 빈공간 위치 정보

for i in range(n):
    board.append(list(input().split()))
    for j in range(n):
        if board[i][j] == 'T':
            teachers.append((i, j))
        if board[i][j] == 'X':
            spaces.append((i, j))

def watch(x,y,direction):
    if direction == 0:
        # 왼쪽으로 감시
        while y >= 0:
            # 학생이 있는 경우
            if board[i][j] == 'S':
                return True
            if board[i][j] == 'O':
                return False
            y += 1
    #   오른쪽 방향으로 감시
    if direction == 1:
        while y < n:
            # 학생이 있는 경우
            if board[i][j] == 'S':
                return True
            if board[i][j] == 'O':
                return False
            x -= 1
    # 위쪽 방향으로 감시
    if direction == 2:
        while x >= 0:
            # 학생이 있는 경우
            if board[i][j] == 'S':
                return True
            if board[i][j] == 'O':
                return False
            x -= 1
            # 아래쪽으로 감시
    if direction == 3:
        while x < n:
            # 학생이 있는 경우
            if board[i][j] == 'S':
                return True
            if board[i][j] == 'O':
                return False
            x += 1
    return False

def process():
    for x,y in teachers:
        for i in range(4):
            if watch(x,y,i):
                return True
    return False

find  = False

# 빈공간에 3개 골라서
for data in combinations(spaces, 3):
    # O 표시하고
    for x, y in data:
        board[x][y] = 'O'
    if not process():
        # 원하는 경우를 발견했을 경우
        find = True
        break
    for x,y in data:
        board[x][y] = 'X'

if find:
    print("YES")
else:
    print("NO")