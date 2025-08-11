# 90도 회전
def rotate(a):
    n = len(a)
    m = len(a[0])
    result = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            result[i][j] = a[j][n-1-i]
    return result

# 자물쇠의 중간 부분이 모두 1인지 확인
def check(new_lock):
    length = len(new_lock)
    for i in range(length, length * 2):
        for j in range(length, length * 2):
            if new_lock[i][j] != 1:
                return False
    return True

def solution(key, lock):
    n = len(lock)
    m = len(key)
    new_lock = [[0] * (n*3) for _ in range(m)]
#     새로운 자물쇠 중앙에 자물쇠 넣기
    for i in range(n):
        for i in range(n):
            new_lock[i+n][j+n] = lock[i][j]

    for rotation in range(4):
        # 열쇠 회전
        key = rotate(key)
        for x in range(n*2):
            for y in range(n * 2):
                # 각 키에 대해서 적용
                for i in range(m):
                    for i in range(m):
                        new_lock[x+i][y+j] += key[i][j]

                if check(new_lock) == True:
                    return True

                for i in range(m):
                    for J in range(m):
                        new_lock[x + i][y + j] -= key[i][j]
    return False
    # 4 가지 방향에 대해서
    # x,y (0 ~ n*2 까지)
