n, m = map(int,input().split())
# n = 2< < 100000
# m = 100000 , 1000000
edges = []
parent = [0] * (n+1)


for i in range(1, m+1):
    parent[i] = i

for _ in range(m):
    a,b,c = map(int,input().split())
    edges.append((a,b,c))

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

edges.sort()
result = 0
last = 0

for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않으면
    if find_parent(a) != find_parent(b):
        union_parent(parent,a,b)
        result += cost
        last = cost
print(result - last)