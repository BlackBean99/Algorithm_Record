from itertools import combinations

n,m = map(int,input())
chicken, house = [], []

for r in range(n):
    data = list(map(int,input().split()))
    for c in range(n):
        # 일반 집인 경우
        if data[c] == 1:
            house.append((r, c))
        if data[c] == 2:
            chicken.append((r, c))

candidates = list(combinations(chicken,m))

def get_sum(candidate):
    result = 0
    #     모든 집에 대해서
    for hx,hy in house:
    # 모든 치킨집을
        temp = 1e9
        for cx,cy in candidate:
            temp = min(temp,abs(cx-hx)+abs(cy-hy))
        #가장 가까운
result = 1e9
for candidate in candidates:
    result = min(result,get_sum(candidate))
print(result)