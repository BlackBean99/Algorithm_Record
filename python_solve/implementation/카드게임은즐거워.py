import bisect

# A, B 리스트 입력 받기
A_len, B_len = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# A 리스트 정렬
A.sort()

# 교집합 찾기
result = []
for num in B:
    index = bisect.bisect_left(A, num)
    if index < A_len and A[index] == num:
        result.append(num)

# 교집합 중 가장 긴 길이 찾기
max_length = 0
for i in range(len(result)):
    for j in range(i, len(result)):
        if A.index(result[j]) - A.index(result[i]) + 1 == j - i + 1:
            max_length = max(max_length, j - i + 1)

# 출력
print(max_length)
