from itertools import combinations
n, m = map(int,input().split())

data = []
chicken, house = [], []

for r in range(n):
    data = list(map(int,input().split()))
    for c in range(n):
        if data[c] == 1:
            house.append((r,c))
        if data[c] == 2:
            chicken.append((r,c))

candidates = list(combinations(chicken,m))

def get_sum(candidates):
    result = 0
    # 모든 집에 대해서
    for hx,hy in house:
        temp = 1e9
        for cx,cy in chicken:
            temp = min(temp, abs(cx-hx) + abs(cy-hy))

result = 1e9
for candidate in candidates:
    result = min(result,get_sum(candidate))
print(result)