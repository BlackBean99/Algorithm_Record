# 단순하게 생각해보자
# 완전 탐색으로간다
def solution(s):
    answer = len(s)
    # 현재 인덱스가 있고
    # step 단위로 비교를 핡건데
    for step in range(1,len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step]
        count = 1
        #     단위별 점프해서 비교
        for j in range(step, len(s), step):
            # 비교했을 때 같으면
            if prev == s[j:j+step]:
                # 카운트를 늘리고
                count += 1
            # 아니면
            else:
                # 이전 비교 결과를 반영하고
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j+step]
                # 카운트를 1로 초기화한다.
                count = 1
        compressed += str(count) + prev if count >= 2 else prev
    # 매번 가장 짧은 길이를 계산한다.
        answer = min(answer, len(compressed))
    return answer