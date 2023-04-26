def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if target == array[mid]:
        return mid
    elif array[mid] > target:
        binary_search(array, target, start, mid -1)
    else:
        return binary_search(array, target, mid + 1, end)
    return None


n = int(input())
array = list(map(int, input().split()))
array.sort()

m = int(input())
x = list(map(int, input().split()))

for i in x:
    result = binary_search(array, i, 0, n - 1)
    if result is not None:
        print('yes', end=' ')
    else:
        print('no', end=' ')
