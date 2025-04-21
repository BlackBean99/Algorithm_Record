import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 방향 배열 추가
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

var n = 0 // board size
var m = 0 // max color value
var map = Array(0) { IntArray(0) }
var visited = Array(0) { BooleanArray(0) }


fun main() = with(BufferedReader(InputStreamReader(Ststem.`in`))) {
    val (nInput, mInput) = readLine().split(" ").map{ it.toInt() }
    n = nInput
    m = mInput
    map = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) {false} }

    for(i in 0 until n){
        map[i] = readLine().split(" ").map {it.toInt()}.toIntArray()
    }
    whlie(true) {
        resetVisited()
        var maxSize = 0
        var maxRainbowCount = 0
        var maxGroup = mutableListOf<Pair<Int,Int>>()
        var maxStandardBlockPos = Pair(n,m)

        for(i in 0 until n){
            for(j in 0 until n){
                // 일반 블록만 탐ㅐ 시작
                if(!visited[i][j] && map[i][j] > 0){
                    val group = findBlockGroup(i,j)
                    if(group.size < 2) continue

                    val rainbowCount = countRainbowBlocks(group)
                    val standardBlock = findStandardBlock(group)

                    if(group.size > maxSize){
                        maxSize = group.size
                        maxRainbowCount = rainbowCount
                        maxStandardBlockPos = standardBlock
                        maxGroup = group
                    } 
                    // 그룹의 크기가 같은 경우
                    else if (group.size == maxSize){
                        // 무지개 블록의 크기비교
                        if(rainbowCount > maxRainbowCount){
                            maxRainbowCount = rainbowCount
                            maxGroup = group
                            maxStandardBlockPos = standardBlock
                        }
                        // 무지개 블록이 같은 경우
                        else if(rainbowCount == maxRainbowCount){
                            // 행이 더 큰 블록
                            if(standardBlock.first > maxStandardBlockPos.first){
                                maxStandardBlockPos = standardBlock
                                maxGroup = group
                            } // 행이 같으면? 열이 더 큰 블록
                            else if(standardBlock.first == maxStandardBlockPos.first && standardBlock.second >  maxStandardBlockPos.second){
                                maxStandardBlockPos = standardBlock
                                maxGroup = group
                            }
                        }
                    }
                }
            }
        }

        if(maxSize <= 1) break

        score += maxSize * maxSize
        clearBlocks(group)

        applyGravity()
        rotateAnticlockwise()

        applyGravity()
    }
    print(score)
}

fun countRainbowBlocks(blocks: List<Pair<Int,Int>>): Int{
    return blocks.count{ (x,y) -> map[x][y] == 0 }
}

// group에서 0 보다 큰 블럭중에서 
fun findStandardBlock(blocks: List<Pair<Int,Int>>): Pair<Int,Int>{
    blocks.filter{ (x,y) -> map[x][y] > 0 }
        .minWith(compareBy({it.first}, {it.second}))
}


fun applyGravity(){
    for(j in 0 until n){
        for(i  in 0 until n){
            // 여기서 i마다 n까지 가야한다.
            var r = i
            while(r + 1 < n && map[r+1][j] == -2){
                map[r+1][j] = map[r][j]
                map[r][j] = -2
                r++
            }
        }
    }
}

fun clearBlocks(group: List<Pair<Int,Int>>){
    for((x,y) in group){
        map[x][y] = -2
    }
}

fun rotateAnticlockwise(){

}

fun findBlockGroup(startX: Int, startY: Int): List<Pair<Int,Int>> {
    // startX,startY부터 시작하는 컬러가 일치하거나 무지개 블럭(-2)인 애들의 BFS
    val queue: Queue<Pair<Int,Int>> = LinkedList()
    val group = MutableListOf<Pair<Int,Int>>()
    val color = map[startX][startY]

    queue.add(Pair(startX,startY))
    group.add(Pair(startX,startY))
    visited[startX][startY] = true

    while(queue.isNotEmpty()){
        val (x,y) = queue.poll()
        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(isBound(nx,ny) && !visited[nx][ny]){
                if(color == map[nx][ny] || map[nx][ny] == 0)
                queue.add(Pair(nx,ny))
                group.add(Pair(nx,ny))
                visited[nx][ny] = true
            }
        }
    }

    // 무지개 블럭은 재사용이 가능하니 방문처리 초기화
    for((x,y) in group){
        if(map[x][y] == 0) visited[x][y] = false
    }
    return group
}

fun isBound(x: Int, y: Int): Boolean{
    if(x in 0 until n && y in 0 until n){
        visited[x][y] = true
    }
}



fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (nInput, mInput) = readLine().split(" ").map { it.toInt() }
    n = nInput
    m = mInput
    map = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) { false } }

    // 맵 입력 받기
    for (i in 0 until n) {
        map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var score = 0

    // 더 이상 제거할 블록이 없을 때까지 반복
    while (true) {
        // 방문 배열 초기화
        resetVisited()
        
        // 가장 큰 블록 그룹 찾기
        var maxSize = 0
        var maxRainbowCount = 0
        var maxGroup = mutableListOf<Pair<Int, Int>>()
        var maxStandardBlockPos = Pair(n, n) // 기준 블록 위치 (행, 열 값이 가장 작은 블록)
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                // 일반 블록(색이 있는 블록)만 시작점으로 처리
                if (!visited[i][j] && map[i][j] > 0) {
                    val group = findBlockGroup(i, j)
                    
                    // 크기가 2보다 작으면 블록 그룹이 아님
                    if (group.size < 2) continue
                    
                    val rainbowCount = countRainbowBlocks(group)
                    val standardBlock = findStandardBlock(group)
                    
                    // 더 큰 그룹을 찾은 경우
                    if (group.size > maxSize) {
                        maxSize = group.size
                        maxRainbowCount = rainbowCount
                        maxGroup = group
                        maxStandardBlockPos = standardBlock
                    } 
                    // 크기가 같은 경우
                    else if (group.size == maxSize) {
                        // 무지개 블록 수로 비교
                        if (rainbowCount > maxRainbowCount) {
                            maxRainbowCount = rainbowCount
                            maxGroup = group
                            maxStandardBlockPos = standardBlock
                        } 
                        // 무지개 블록 수가 같은 경우
                        else if (rainbowCount == maxRainbowCount) {
                            // 행이 더 큰 블록
                            if (standardBlock.first > maxStandardBlockPos.first) {
                                maxGroup = group
                                maxStandardBlockPos = standardBlock
                            } 
                            // 행이 같고 열이 더 큰 블록
                            else if (standardBlock.first == maxStandardBlockPos.first && 
                                     standardBlock.second > maxStandardBlockPos.second) {
                                maxGroup = group
                                maxStandardBlockPos = standardBlock
                            }
                        }
                    }
                }
            }
        }
        
        // 제거할 블록 그룹이 없으면 종료
        if (maxSize <= 1) break
        
        // 블록 제거 및 점수 계산
        score += maxSize * maxSize
        clearBlocks(maxGroup)
        
        // 중력 적용
        applyGravity()
        
        // 90도 반시계 방향 회전
        rotateAnticlockwise()
        
        // 다시 중력 적용
        applyGravity()
    }
    
    // 최종 점수 출력
    println(score)
}

// 방문 배열 초기화
fun resetVisited() {
    for (i in 0 until n) {
        for (j in 0 until n) {
            visited[i][j] = false
        }
    }
}

// 블록 그룹 찾기 (BFS)
fun findBlockGroup(startX: Int, startY: Int): MutableList<Pair<Int, Int>> {
    val group = mutableListOf<Pair<Int, Int>>()
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val color = map[startX][startY]
    
    // 시작점 추가
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true
    group.add(Pair(startX, startY))
    
    // 블록 그룹 탐색
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            
            // 유효한 위치인지 확인
            if (isInBound(nx, ny) && !visited[nx][ny]) {
                // 같은 색 블록이거나 무지개 블록인 경우
                if (map[nx][ny] == color || map[nx][ny] == 0) {
                    queue.add(Pair(nx, ny))
                    group.add(Pair(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
    }
    
    // 무지개 블록은 다른 그룹에서도 사용할 수 있도록 방문 처리 초기화
    for (block in group) {
        if (map[block.first][block.second] == 0) {
            visited[block.first][block.second] = false
        }
    }
    
    return group
}

// 무지개 블록 개수 세기
fun countRainbowBlocks(group: List<Pair<Int, Int>>): Int {
    return group.count { (x, y) -> map[x][y] == 0 }
}

// 기준 블록 찾기 (일반 블록 중 행, 열 번호가 가장 작은 블록)
fun findStandardBlock(group: List<Pair<Int, Int>>): Pair<Int, Int> {
    return group
        .filter { (x, y) -> map[x][y] > 0 }
        .minWith(compareBy({ it.first }, { it.second }))
}

// 블록 제거
fun clearBlocks(blocks: List<Pair<Int, Int>>) {
    for ((x, y) in blocks) {
        map[x][y] = -2  // 빈 공간은 -2로 표시
    }
}

// 중력 적용
fun applyGravity() {
    for (j in 0 until n) {
        for (i in n - 2 downTo 0) {
            if (map[i][j] >= 0) {  // 일반 블록 또는 무지개 블록
                var r = i
                // 아래로 떨어질 수 있는 만큼 떨어뜨림
                while (r + 1 < n && map[r + 1][j] == -2) {
                    map[r + 1][j] = map[r][j]
                    map[r][j] = -2
                    r++
                }
            }
        }
    }
}

// 반시계 방향으로 90도 회전
fun rotateAnticlockwise() {
    val temp = Array(n) { IntArray(n) }
    
    for (i in 0 until n) {
        for (j in 0 until n) {
            temp[n - 1 - j][i] = map[i][j]
        }
    }
    
    for (i in 0 until n) {
        for (j in 0 until n) {
            map[i][j] = temp[i][j]
        }
    }
}

// 격자 범위 체크
fun isInBound(x: Int, y: Int): Boolean {
    return x in 0 until n && y in 0 until n && map[x][y] != -1
}

// 모든 블록이 제거되었는지 확인
fun isAllEmpty(): Boolean {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] > 0) {
                return false
            }
        }
    }
    return true
}