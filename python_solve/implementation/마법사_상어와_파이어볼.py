n,m,k = map(int,input().split())

# 질량 m, 속력 v, 방향 d


dr = [0,1,1,1,0,-1,-1,-1]
dc = [1,1,0,-1,-1,-1,0,1]


data = []
for i in range(m):
    r,c,m,s,d = map(int,input().split())
    data.append((r,c,m,s,d))

# 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7



# 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
def move(fire):
    temp = []
    for r,c,m,s,d in fire:
        nr = r + dr[d] * s
        nc = c + dc[d] * s
        if nr >= n:
            nr = n
        elif nr < 1:
            nr = 1
        if nc >= n:
            nc = n
        elif nc < 1:
            nc = 1
        if 0 <= nr < n and 0<= nc < n:
            temp.append((nr,nc,m,s,d))
        else:
            temp.append((nr,nc,m,s,d))
    return temp

def sum_fire(fire, n):
    answer = []
    index = 0
    # the number of concatenations
    count = 0
    data = [[[] for _ in range(n)] for _ in range(n)]
    
    for a, b, c, d, e in fire:
        data[a][b].append((c, d, e))
    
    for i in range(n):
        for j in range(n):
            a, b, c = 0, 0, 0
            for duplicate_fire in data[i][j]:
                a += duplicate_fire[0]
                b += duplicate_fire[1]
                c += duplicate_fire[2]
            data[i][j] = (a, b, c)
    return data

    # answer.append(fire.pop())
    # while answer:
    #     r,c,m,s,d = answer.pop()
    #         # 같은 칸에 있으면 합친다.
    #     index += 1
    #     for nr,nc,nm,ns,nd in fire[index:]:
    #         if r == nr and c == nc:
    #             count += 1
    #             answer.append((r, c, m + nm, s + ns, count * 2))
    #             print("합쳐졌다!! :" , r, " / ", c, " / ", m + nm, " / ", s + ns, " / " , count * 2)
    #         else:
    #             answer.append((r, c,m ,s , count))
    #             print("안합치고 넣을게!! :" , r, " / ", c, " / ", m, " / ", s, " / " , count)
    # return answer

def merge_directions(directions):
    if all(d % 2 == 0 for d in directions) or all(d % 2 != 0 for d in directions):
        return [0, 2, 4, 6]
    return [1, 3, 5, 7]


temp = move(data)

# answer = sum_fire(temp,m)
for i in range(n):
    for j in range(n):
        print(answer[i][j] , end = ' ')
    print()





# 이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
# 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
# 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
# 파이어볼은 4개의 파이어볼로 나누어진다.
# 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
# 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
# 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
# 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
# 질량이 0인 파이어볼은 소멸되어 없어진다.
# 질량이 0 이면 소멸

    