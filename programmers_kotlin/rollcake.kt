class Solution {
    fun solution(topping: IntArray): Int {
        val leftSet = mutableSetOf<Int>()
        val rightMap = mutableMapOf<Int, Int>()

        // 모든 토핑을 rightMap에 저장 (초기 상태)
        for (t in topping) {
            rightMap[t] = rightMap.getOrDefault(t, 0) + 1
        }

        var count = 0

        // 왼쪽에서 하나씩 추가하고, 오른쪽에서 제거하면서 비교
        for (i in topping.indices) {
            leftSet.add(topping[i]) // 왼쪽에 추가
            rightMap[topping[i]] = rightMap[topping[i]]!! - 1

            if (rightMap[topping[i]] == 0) {
                rightMap.remove(topping[i]) // 개수가 0이 되면 제거
            }

            // 왼쪽과 오른쪽의 토핑 종류 수가 같으면 count 증가
            if (leftSet.size == rightMap.size) {
                count++
            }
        }

        return count
    }
}
