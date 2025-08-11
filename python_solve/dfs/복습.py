n, m = map(int, input().split())

array = []
for i in range(n):
    array.append(list(map(int,input())))


def dfs(x, y):
    # 경계를 넘어 가거나 이미 방문한 노드면 방문 하지 않는다.
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    if array[x][y] == 0:
        array[x][y] = 1
        # 상, 하, 좌, 우 재귀 호출
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False

cnt = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j):
            cnt += 1

print(cnt)



