import kotlin.system.exitProcess


lateinit var ladder : Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, h) = readLine().split(" ").map { it.toInt() }

    ladder = Array(h + 1) { IntArray(n + 1) }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        ladder[a][b] = 1
        ladder[a][b + 1] = 2
    }

    for (i in 1 until 4) {
        dfs(line = 1,
         cnt = 0,
          max = i,
           n = n,
            h = h)
    }

    println(-1)
}

fun dfs(line: Int, cnt: Int, max: Int, n: Int, h: Int) {
    if (cnt > max) {
        return
    }

    if (checkLadder(n, h)) {
        println(cnt)
        exitProcess(0)
    }

    for (i in line..h) {
        for (j in 1 until n) {
            if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                ladder[i][j] = 1
                ladder[i][j + 1] = 2

                dfs(i, cnt + 1, max, n, h)

                ladder[i][j] = 0
                ladder[i][j + 1] = 0
            }
        }
    }
}



fun checkLadder(n: Int, h: Int): Boolean {
    for (i in 1..n) {
        var x = 1
        var y = i

        for (j in 0 until h) {
            if (ladder[x][y] == 1) y++
            else if (ladder[x][y] == 2) y--
            x++
        }

        if (y != i) return false
    }
    return true
}