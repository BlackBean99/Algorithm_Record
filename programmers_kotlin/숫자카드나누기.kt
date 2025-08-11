class Solution {
        fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer = 0
        var gcdA = arrayA[0]
        var gcdB = arrayB[0]

        // 각 배열의 최대공약수 구하기
        val size = arrayA.size
        for (i in 1 until size) {
            gcdA = GCD(gcdA, arrayA[i])
            gcdB = GCD(gcdB, arrayB[i])
        }
        print("A : ${gcdA} / B : ${gcdB}")
        if(diversial(gcdA, arrayB)) answer = Math.max(answer, gcdA)
        if(diversial(gcdB, arrayA)) answer = Math.max(answer, gcdB)
        
        return answer
    } // End of solution

    fun diversial(a: Int, array: IntArray): Boolean{
        array.forEach{
            if(it % a == 0) return false
        }
        return true
    }
    // 최대공약수 구하는 메소드
     fun GCD(a: Int, b: Int): Int {
        if (a % b == 0) return b
        return GCD(b, a % b)
    } // End of GCD
} // End of Solution class