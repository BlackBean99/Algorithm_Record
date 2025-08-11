# 331 , 527
from itertools import combinations

n,m = map(int,input().split())
chicken, house = [], []

for r in range(n):
    data = list(map(int,input().split()))
    for c in range(n):
        if data[c] == 1:
            house.append((r,c))
        if data[c] == 2:
            chicken.append((r, c))

#   m개의 치킨집을 뽑는 조합 계산
candidates = list(combinations(chicken,m))

# 치킨 거리의 합을 계산하는 함수
def get_sum(candidate):
    result = 0
    # 모든 집에 대하여
    for hx, hy in house:
        temp = 1e9
#         각 치킨 집을 돌면서
        for cx, cy in candidate:
            #  치킨 거리의 최솟값을 계산한다.
            temp = min(temp, abs(hx-cx) + abs(hy - cy))
        result += temp
    return result

result = 1e9

for candidate in candidates:
    result = min(result, get_sum(candidate))
print(result)


