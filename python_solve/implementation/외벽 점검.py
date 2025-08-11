from itertools import permutations
def solution(n, weak, dist):
    # weak 2배로 늘리기 (원형을 일차원으로 변경)
    length = len(weak)
    answer = len(dist)
    for i in range(length):
        weak.append(weak[i] + n)
    for start in range(length):
        for friends in permutations(dist,len(dist)):
            # 지금 선택한 친구가 확인할 수 있는 최대 영역
            count = 1
            # 첫번째 count
            position = weak[i] + friends[count -1]
            # 시작점부터 모든 weak 점을 뒤진다.
            # 영역을 다 뒤졌는데도 문제가 없으면 그 count 로 다 해결한거다
            for index in range(start,start + length):
            #     문제 케이스 1 : 영역을 벗어나면
                if position < weak[index]:
            #         친구를 하나 더 쓴다.
                    count += 1
                    if count > len(dist):
                        break
            #         친구를 쓸 수 있는 만큼 썼으면 / 지점 + 친구 커버 영역
                    position = weak[index] + friends[count -1]
            answer = min(answer,count)
    if count > len(dist):
        return -1
    return count