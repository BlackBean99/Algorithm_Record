from collections import deque
n,m,k,x = map(int,input().split())

graph = [[] * (n+1) for _ in range(n+1)]

for i in range(n):
    a,b = map(int,input().split())
    graph[a].append(b)
q = deque([x])


distance = [-1] * (n+1)

while q:
    now = q.popleft()
    for next_node in graph[now]:
        if distance[next_node] == -1:
            distance[next_node] = distance[now] + 1
            q.append(next_node)


isTrue = False
for i in range(1,n+1):
    if distance[i] == k:
        print(i)
        isTrue = True

if isTrue == False:
    print(-1)




