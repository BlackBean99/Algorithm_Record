import java.util.*
import java.io.*

private val numList: MutableList<Int> = mutableList()
private val opList: MutableList<Int> = mutableList()
private val seqOp: MutableList<Int> = mutableList()
private lateinit var visited : BooleanArray
private var minResult = Integer.MAX_VALUE
private var maxResult = Integer.MIN_VALUE


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    numList.addAll(br.readLine().split(" ").map{ it.toInt() })
    visited = BooleanArray(n-1)
    
    br.readLine.split(" ").map{ it.toInt() }.forEachIndexed { index, it  -> 
        repeat(it){
            opList.add(index)
        }
    }
    // 카운트를 0으로 만들고
    // 시뮬레이션
    operate(n-1)
    print(maxResult)
    print(minResult)
}


fun operate(count: Int){
    var result = numList[0]
    if(count == 0){
        repeat(n-1){ i ->
            when(seqOp[i]){
                0 -> {
                    result += numList[i+1]
                }
                1 -> {
                    result -= numList[i+1]
                }
                2 -> {
                    result *= numList[i+1]
                }
                3 -> {
                    result /= numList[i+1]
                }
            }
        }
        minResult = minOf(minResult, result)
        maxResult = maxOf(maxResult, result)
        return 
    }

    for(i in until n-1){
        if(!visited[i]) {
            seqOp.add(opList[i])
            visited[i]= true
            operate(count - 1)
            seqOp.removeLast()
            visited[i] = false
        }
    }

}