import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private val numList : MutableList<Int> = mutableListOf()
private val opList: MutableList<Int> = mutableListOf()
private val seqOp:  MutableList<Int> = mutableListOf()
private lateinit var visited : BooleanArray
private var minResult = Integer.MAX_VALUE
private var maxResult = Integer.MIN_VALUE

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    numList.addAll(br.readLine().split(" ").map{ it.toInt() })
    visited = BooleanArray(n - 1)
    br.readLine().split(" ").map{ it.toInt()}.forEachIndexed { index, it ->
        repeat(it){
            opList.add(index) // 인덱스를 저장(연산자니까)를 여러개
        }
    } // 덧셈, 뺄셈, 곱셈, 나눗셈의 개수
    operate(n - 1)
    println(maxResult)
    print(minResult)
}

// 순열 백트래킹
fun operate(count : Int){
    var result = numList[0]
    if(count == 0){
        repeat(n - 1){ i ->
            when(seqOp[i]){
                0 -> {
                    result += numList[i + 1]
                }
                1 -> {
                    result -= numList[i + 1]
                }
                2 -> {
                    result *= numList[i + 1]
                }
                3 -> {
                    result /= numList[i + 1]
                }
            }
        }
        minResult = minOf(minResult, result)
        maxResult = maxOf(maxResult, result)
        return
    }
    for(i in 0 until n - 1){
        if(!visited[i]) {
            seqOp.add(opList[i])
            visited[i] = true
            operate(count - 1)
            seqOp.removeLast()
            visited[i] = false
        }
    }
}