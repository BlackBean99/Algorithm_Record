def divide(p):
    open_p = 0
    close_p = 0

    for i in range(len(p)):
        if p[i] == '(':
            open_p += 1
        else:
            close_p += 1
        if open_p == close_p:
            # 닫힌 괄호가 다 짝이 맞았으먄 그 이전과 이후 배열로 구분한다
            return p[:i+1], p[i+1:]

def check(u):
    stack = []
    for p in u:
        if p == '(':
            stack.append(p)
        else:
            if not stack:
                return False
            stack.pop()
    return True

def solution(p):
    if not p:
        return ""
    u,v = divide(p)
    if check(u):
        # 3.문자열u가 "올바른 괄호 문자열"이라면문자열v에대해1단계부터다시수행합니다.
        # 3 - 1.수행한 결과 문자열을 u 에 이어붙인 후 반환 합니다.
        return u + solution(v)
    else:
        answer = '('
        answer += solution(v)
        answer += ')'

    # 처음걸 떄고
    for p in u[1:len(u)-1]:
        if p == '(':
            answer += ')'
        else:
            answer += '('
    return answer
print(solution("(()())()"))