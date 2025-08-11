class Solution {
    private lateinit var visited: Array<BooleanArray>
    private val dx = arrayOf(0, 1, 0, -1)
    private val dy = arrayOf(1, 0, -1, 0)

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(5)

        for (round in places.indices) {
            var isSafe = true
            visited = Array(5) { BooleanArray(5) { false } }
            for(i in 0 until 5){
                for(j in 0 until 5){
                    if(!visited[i][j] && places[round][i][j] == 'P'){
                        if(!checkedDistance(i,j,places[round])){
                            isSafe = false
                            break
                        }
                    }
                }
                if(!isSafe) break
            }
            answer[round] = if (isSafe) 1 else 0
        }

        return answer
    }
    fun checkedDistance(x: Int, y: Int, places: Array<String>): Boolean{
        val queue = ArrayDeque<Point>()
        queue.add(Point(x,y,0))
        visited[x][y] = true
        
        while(queue.isNotEmpty()){
            val current = queue.removeFirst()
            if(current.distance in 1..2 && places[current.x][current.y] == 'P'){
                return false
            }
            if(current.distance >= 2) continue
            
            for(i in 0 until 4){
                val nx = current.x + dx[i]
                val ny = current.y + dy[i]
                
                if (nx in 0..4 && ny in 0..4 && !visited[nx][ny] && places[nx][ny] != 'X') {
                    visited[nx][ny] = true
                    queue.add(Point(nx,ny, current.distance + 1))
                }
               
            }
        }
            return true
    }

    data class Point(val x: Int, val y: Int, val distance: Int)
}
