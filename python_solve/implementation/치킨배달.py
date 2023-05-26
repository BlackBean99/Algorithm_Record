from itertools import combinations

n,m = map(int,input().split())
chicken, house = [], []

for r in range(n):
    data  = list(map(int,input().split()))
    for c in range(n):
        if data[c] == 1:
            house.append(((r,c)))
        elif data[c] == 2:
            chicken.append((r,c))
# 모든 치킨집 중에서 m개의 치킨집을 뽑는 조합 계산
candidates = list(combinations(chicken,m))

def get_sum(candidate):
    result = 0
    # 모든 집에 대하여
    for hx, hy in house:
        # 가장 가까운 치킨집을 찾기
        temp = 1e9
        for cx,cy in candidate:
            temp = min(temp,abs(hx-cx) + abs(hy-cy))
        result += temp
    return result

result = 1e9
for candidate in candidates:
    result = min(result, get_sum(candidate))

print(result)
#  집의 위치를 저장한 배열
#  치킨집의 위치를 저장한 배열

