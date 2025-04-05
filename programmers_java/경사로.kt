import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var answer = 0

    // 가로줄 검사
    for (i in 0 until n) {
        if (canPass(map[i], l)) answer++
    }

    // 세로줄 검사
    for (j in 0 until n) {
        val col = IntArray(n) { i -> map[i][j] }
        if (canPass(col, l)) answer++
    }

    println(answer)
}

fun canPass(line: IntArray, l: Int): Boolean {
    val n = line.size
    val used = BooleanArray(n) // 경사로 설치 여부

    for (i in 0 until n - 1) {
        val diff = line[i + 1] - line[i]

        if (diff == 0) continue // 평지

        else if (diff == 1) {
            // 뒤가 높다 → 앞에 경사로 필요
            for (j in i downTo i - l + 1) {
                if (j < 0 || line[j] != line[i] || used[j]) return false
                used[j] = true
            }
        }

        else if (diff == -1) {
            // 앞이 높다 → 뒤에 경사로 필요
            for (j in i + 1 until i + l + 1) {
                if (j >= n || line[j] != line[i + 1] || used[j]) return false
                used[j] = true
            }
        }

        else return false // 높이차 2 이상 → 불가
    }

    return true
}
