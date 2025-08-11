a,b = map(int,input().split())

array = list(map(int,input().split()))
array.sort()
count = 0
for i in range(a-1):
    for j in range(i,a):
    # i번 공과 j 번 무게가 같으면
        if array[i] == array[j]:
            continue
        else:
            count += 1
print(count)