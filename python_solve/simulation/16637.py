import sys

input = sys.stdin.readline

result = -2 ** 31 - 1   # 최솟값 -1


def calc(num, op):      # 남은 수식을 전부 계산하는 함수
    while op:
        oper = op.pop(0)
        n1, n2 = num.pop(0), num.pop(0)
        if oper == '+':
            num.insert(0, n1 + n2)
        elif oper == '-':
            num.insert(0, n1 - n2)
        elif oper == '*':
            num.insert(0, n1 * n2)
    return num[0]


def solve(cnt, num, op):
    global result
    if cnt == n // 2 or len(num) == 1:      # 수식의 끝까지 도달했거나 남은 피연산자가 1개인 경우 종료
        result = max(result, calc(num, op))
        return

    solve(cnt + 1, num[:], op[:])           # 이번 연산자를 우선 계산하지 않고 넘김

    try:
        n1, n2 = num.pop(cnt), num.pop(cnt) # 괄호를 추가한 경우
        oper = op.pop(cnt)                  # 우선적으로 계산한다
        if oper == '+':                     # 이 연산자 바로 다음 연산자는 우선 계산하지 않는다(괄호 중첩)
            num.insert(cnt, n1 + n2)
        elif oper == '-':
            num.insert(cnt, n1 - n2)
        elif oper == '*':
            num.insert(cnt, n1 * n2) 
                                            # pop, insert 연산으로 index가 1감소했기 때문에
        solve(cnt + 1, num[:], op[:])       # 바로 다음 연산자를 건너뛰지만, cnt를 1만 증가시킨다
                                             
    except:
        0           # 남은 연산의 수가 없는 경우 pop에서 index range error 발생


n = int(input())
expr = input()
num, op = [], []
for i in range(n):  # 연산자와 피연산자를 나누어 저장
    if i % 2 == 0:
        num.append(int(expr[i]))
    else:
        op.append(expr[i])
solve(0, num, op)
print(result)
