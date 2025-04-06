import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }


    val map = Array(n) {
        br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    }

    var answer = 0

    // 가로줄 검사
    for(i in until n){
        if (canPass(map[i], l)) answer++
    }

    // 세로줄 검사
    for(j in 0 until n){
        val col = IntArray(n) {i -> map[i][j]}
        if(canPass(col,l)) answer++
    }

    println(answer)
}


fun canPass(line: IntArray, l: Int): Boolean{
    val n = line.size
    val used = BooleanArray(n)

    for(i in 0 until n-1){
        val diff = line[i+1] - line[i]

        if(diff == 0) continue
        // 뒤가 높은 경우
        else if(diff == 1){
            // 다시 내려간다.
            for(j in i downTo i - l + 1){
                if(j < 0 || line[j] != line[i] || used[j]) return false
                used[j] = true
            }
        }
        else if(diff == -1){
            for(j in i downTo i - l + 1){
                if(j < 0 || line[j] != line[i] || used[j]) return false
                used[j] = true
            }
        }
        else return false
    }
    return true
}