n = int(input())
array = list(map(int,input().split()))



array.sort()
#  총 그룹의 수
result = 0
#  현재 그룹에 있는 사람 수
count = 0
# 공포도가 낮은 순으로 하나씩 순회하면서
for i in array:
#     현재 그룹에 포함시키기
    count += 1
    if count >= i:
        result += 1
        count = 0
print(result)

