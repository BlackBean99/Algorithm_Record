import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    # 시간이 적은 순서대로 삽입해야 하므로 우선순위 큐를 사용한다
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q,(food_times[i], i+1))

    # 지금까지 먹은 음식 시간
    sum_value =0
    # 이전 음식까지 먹은 시간
    previoud = 0

    length = len(food_times)
    while sum_value + ((q[0][0] - previoud) * length) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previoud) * length
        length -= 1
        previoud = now
    # 음식의 번호 기준으로 정렬
    result = sorted(q, key = lambda x: x[1])
    return result[(k - sum_value) % length]