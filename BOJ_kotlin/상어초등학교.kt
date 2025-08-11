fun main() = with(System.`in`.bufferedReader){
    n = readLine().toInt()
    num = IntArray(n * n)
    info = Array<List<Int>>(n * n+1) { listOf<Int>() }
    

    for(i in until n*n){
        val input = readLine().split(" ").map{ toInt() }
        num[i] = input[0]
        info[n] = input.subList(1,5)
    }
    init()

    for(i in num.indices){
        var seat = findSeat(num[i])

        student[seat.first][seat.second] = -1
        empty[seat.first][seat.second] = -1

        for(i in dx.indices){
            var nx = seat.first + dx[i]
            var ny = seat.second + dy[i]
            if(!isNotWall(nx,ny) || empty[nx][ny] < 0) continue
            empty[nx][ny]--
        }
    }
    print(satisfied())
}
private fun findSeat(now: Int) : Pair<Int, Int> {
    var max = 0
    var list = mutableListOf<Pair<Int,Int>>()
    for(i in empty.indices){
        for(j in empty[i].indices){
            // 빈칸에 자리를 찾아야한다.
            if(student[i][j] != 0) continue
            var likes = 0
            for(k in dx.indices){
                var nx = i + dx[k]
                var ny = j + dy[k]
                if(!isNotWall(dx,dy)) continue
                if(info[now].contains(student[nx][ny])) likes++
            }
            if(max < likes){
                list.clear()
                list.add(Pair(i,j))
                max = likes
            } else if (max == likes){
                // 2번 조건
                list.add(Pair(i,j))
            }
        }
    }
    list.sortedWith(compareByDescending({empty[it.first][it.second]}))
    return list[0]
}

private fun isNotWall(x: Int , y: Int) = x in 0 until n && y in 0 until n

private fun init(){
    for(i in empty.indices){
        for(j in empty[0].indices){
            empty[i][j] = 4
            if(i == 0 || i == n-1) empty[i][j]--
            if(j == 0 || j == n-1) empty[i][j]--
        }
    }
}

private fun satisfied(): Int{
    var sum = 0
    for(i in student.indices){
        for(j in student[i].indices){
            var cnt = 0
            for(k in dx.indices){
                var nx = i + dx[i]
                var ny = j + dy[i]
                if(!isNotWall(nx,ny)) continue
                if(info[student[i][j]].contains(student[nx][ny])) cnt++
            }
            if(cnt > 1) sum += Math.pow(10.toDouble(), (cnt - 1).toDouble()).toInt()
            else sum += cnt
        }
    }
    return sum
}
