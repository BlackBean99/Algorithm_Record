def possible(answer):
    for x,y,stuff in answer:
        if stuff == 0: #설치된 것이 '기둥'인 경우
            # 바닥 위 or 보의 한쪽 끝부분 위 or 다른 기둥 위라면 정상
            if y == 0 or [x-1,y,1] in answer [x,y,1] in answer or [x,y-1,0] in answer:
                continue
            return False # 아니라면 거짓 False 반환
        elif stuff == 1: #설치된 것이 보인 경우
            # 한쪽 끝 부분이 기둥 위인 경우 혹은 양쪽 끝부분이 다른 보와 동시에 연결이라면 정상
            if [x,y-1,0] in answer or [x-1,y,1] in answer or [x+1, y-1, 0] in answer:
                continue
            return False
    return True


def solution(n,build_frame):
    answer = []
    for frame in build_frame:
        x,y,stuff,operation = frame
        if operation == 0: # 삭제하는 경우
            answer.remove([x,y,stuff])
            if not possible(answer):
                answer.append([x,y,stuff])
        if operation == 1:
            answer.append([x,y,stuff])
            if not possible(answer):
                answer.remove([x,y,stuff])
    return sorted(answer)

