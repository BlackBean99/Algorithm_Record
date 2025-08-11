import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer = 0
        val trailer = Stack<Int>()
        val subTrailer = Stack<Int>()

        // 메인 스택을 초기화 (컨테이너 벨트)
        for (i in order.size downTo 1) {
            trailer.push(i)
        }

        var index = 0
        while (trailer.isNotEmpty()) {
            if (trailer.peek() == order[index]) {
                trailer.pop()
                answer++
                index++
            } else {
                // 서브 트레일러에서 확인
                if (subTrailer.isNotEmpty() && subTrailer.peek() == order[index]) {
                    subTrailer.pop()
                    answer++
                    index++
                } else {
                    // 더 이상 진행 불가능
                    subTrailer.push(trailer.pop())
                }
            }
        }

        // 남아 있는 서브 트레일러 확인
        while (subTrailer.isNotEmpty() && subTrailer.peek() == order[index]) {
            subTrailer.pop()
            answer++
            index++
        }

        return answer
    }
}
