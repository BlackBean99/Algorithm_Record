import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val value = br.readLine().split(" ").map { it.toInt() } // 첫 줄: N M
    val n = value[0]
    val m = value[1]

    val map = Array(n) { CharArray(m) }

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            map[i][j] = line[j]
        }
    }

    // 디버그 출력
    for (i in 0 until n) {
        for (j in 0 until m) {
            print(map[i][j])
        }
        println()
    }

    // 문제 조건 정리 주석:
    // - 빨간 구슬과 파란 구슬은 같은 위치에 존재할 수 없음
    // - 기울이기 수행 시 동시에 이동
    // - 파란 구슬이 빠지면 실패, 빨간 구슬만 빠지면 성공
    // - 최대 10번 이내의 이동

    // 앞으로 여기에 BFS 등의 로직을 작성할 수 있음
}

// 상태를 저장하는 data class
data class State(
    val rx: Int,
    val ry: Int,
    val bx: Int,
    val by: Int,
    val count: Int
)
