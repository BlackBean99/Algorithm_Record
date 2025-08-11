from collections import deque

n,m = map(int,input().split())
array = []
for i in range(n):
    array.append(list(map(int,input())))

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def dfs(x,y):
    queue = deque()


