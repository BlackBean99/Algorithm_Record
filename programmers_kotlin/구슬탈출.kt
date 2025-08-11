import java.io.*
import java.util.*

data class State(val rx: Int, val ry: Int, val bx: Int, val by: Int, val count: Int)

val dx = intArrayOf(-1, 1, 0, 0) // 상, 하, 좌, 우
val dy = intArrayOf(0, 0, -1, 1)

lateinit var board: Array<CharArray>
var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    n = N
    m = M

    board = Array(n) { CharArray(m) }
    var rx = 0
    var ry = 0
    var bx = 0
    var by = 0

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            board[i][j] = line[j]
            when (line[j]) {
                'R' -> {
                    rx = i
                    ry = j
                }
                'B' -> {
                    bx = i
                    by = j
                }
            }
        }
    }

    println(bfs(rx, ry, bx, by))
}

fun bfs(rx: Int, ry: Int, bx: Int, by: Int): Int {
    val visited = Array(n) { Array(m) { Array(n) { BooleanArray(m) } } }
    val q: Queue<State> = LinkedList()
    q.offer(State(rx, ry, bx, by, 0))
    visited[rx][ry][bx][by] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (cur.count >= 10) return -1

        for (dir in 0..3) {
            var (nrx, nry, rMove) = move(cur.rx, cur.ry, dir)
            var (nbx, nby, bMove) = move(cur.bx, cur.by, dir)

            if (board[nbx][nby] == 'O') continue // 파란 구슬이 빠지면 실패
            if (board[nrx][nry] == 'O') return cur.count + 1 // 빨간 구슬만 빠짐 → 성공

            // 둘이 같은 위치에 있으면 더 멀리서 온 구슬을 한 칸 뒤로
            if (nrx == nbx && nry == nby) {
                if (rMove > bMove) {
                    nrx -= dx[dir]
                    nry -= dy[dir]
                } else {
                    nbx -= dx[dir]
                    nby -= dy[dir]
                }
            }

            if (!visited[nrx][nry][nbx][nby]) {
                visited[nrx][nry][nbx][nby] = true
                q.offer(State(nrx, nry, nbx, nby, cur.count + 1))
            }
        }
    }

    return -1
}

fun move(x: Int, y: Int, dir: Int): Triple<Int, Int, Int> {
    var nx = x
    var ny = y
    var moveCount = 0

    while (true) {
        val nextX = nx + dx[dir]
        val nextY = ny + dy[dir]

        if (board[nextX][nextY] == '#') break
        nx = nextX
        ny = nextY
        moveCount++

        if (board[nx][ny] == 'O') break
    }

    return Triple(nx, ny, moveCount)
}
