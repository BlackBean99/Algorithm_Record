data = input()
lat = data[0]
loc = data[1]

dx = [2,1,-1,-2,-2,-1,1,2]
dy = [1,2,2,1,-1,-2,-2,-1]

data_type = ['a','b','c','d','e','f','g','h']

x_index = data_type.index(lat)

x = x_index
y = int(loc)

count = 0

for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]

    # [(-2 - 1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
    if nx < 0 or nx > 7 or ny < 0 or ny > 7:
        print(nx,"  :  ",ny , "\n")
        continue
    count += 1

print(count)