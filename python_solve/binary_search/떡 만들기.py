n, m = map(int, input().split())
array = list(map(int, input().split()))

array.sort()
result = 0
start = 0
end = max(array)


def get_cut(array, cut):
    sum = 0
    for i in array:
        if i > cut:
            sum += (i - cut)
    return sum


# def binary_search(array, target, start, end):
#     if start > end:
#         return False
#     mid = (start + end) // 2
#     # 현재 위치에서 자른다
#     if get_cut(array, mid) == target:
#         return mid
#     # 결과보다 많이 잘랐을 때
#     elif get_cut(array, mid) > target:
#         binary_search(array, target, mid + 1, end)
#     # 결과보다 적게 잘랐을 때
#     else:
#         binary_search(array, target, start, mid - 1)
#     return mid

#  이전 기록에 의해 판단해야 하기 때문에 재귀를 사용할 수가 없다.
while(start <= end):
    total = 0
    mid = (start + end) // 2
    total = get_cut(array, mid)
    # 적게 잘랐을 경우
    if total < m:
        end = mid - 1
    # 많이 잘랐을 경우
    else:
        result = mid
        start = mid + 1
print(result)
