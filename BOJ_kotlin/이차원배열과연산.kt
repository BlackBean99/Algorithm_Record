fun main() = with(System.`in`.BufferedReader()){
    var answer = 0
    val A = Array(101){IntArray(101)}
    val (r,c,k) = readLine().map { toInt() }
    for (i in 0 until 3) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in 0 until 3) {
            A[i][j] = row[j]
        }
    }
    var rowSize = 3
    var colSize = 3
    var time = 0

    while(time <= 100) {
        if(A[r][c] == k){
            print(time)
            return
        }

        if(rowSize >= colSize){
            // R calculate
            var newColSize = 0
            for(i in 0 until rowSize){
                val newRow = calculage(A[i], colSize)
                for(j in newRow.indices){
                    A[i][j] = newRow[j]
                }
                for(j in newRow.size until 101){
                    A[j][i] = 0
                }
                newColSize = maxOf(newColSize, newRow.size)
            }
            colSize = newColSize.coerceAtMost(100)
        } else {
            // C calculate
            // var newRowSize = 0
            var newRowSize = 0
            for(i in 0 until colSize){
                val tempCol = IntArray(colSize){ A[it][i] }
                val newCol = calculate(tempCol, rowSize)
                for(j in newCol.indices){
                    A[j][i] = newCol[j]
                }
                for(j in newCol.size until 101){
                    A[j][i] = 0
                }
                newRowSize = maxOf(newRowSize, newCol.size)
            }
            rowSize = newRowSize.coerceAtMost(100)
        }
        time++
    }

fun calculate(arr:IntArray, length: Int): IntArray {
    val countMap = mutableMapOf<Int,Int>()
    for(i in 0 until length){
        val num = arr[i]
        if(num == 0) continue
        countMap[num] = countMap.getOrDefault(num,0) + 1
    }

    val sortedList = countMap.toList().sortedWith(compareBy({it.second}, {it.first}))
    val result = ArrayList<Int>()
    for((num, value) in sortedList){
        result.add(num)
        result.add(value)
    }
    return result.take(100).toIntArray()
}