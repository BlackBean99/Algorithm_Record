val dx = intArrayOf(1,1,0,-1,-1,-1,0,1)
val dy = intArrayOf(0,1,1,1,0,-1,-1,-1)

fun main() = with(System.`in`.BufferedReader){
    val answer = 0
    val (n,m,k) = readLine().split(" ").map{ it.toInt() }
    val injection = Array(n){ IntArray(5) }
    val map = Array(n){ IntArray(5) {5} }
    for(i in 0 until n){
        val arr: IntArray = readLine().split(" ").map{ it.toInt() }
        injection[i] = arr
    }
    
    // x,y 별로 
    val trees = Array(n) { Array(n) { LinkedList<Int>> }}
    val deadTrees = Array(n) { Array(n) { LinkedList<Int>> }}
    for(i in 0 until m){
        val (x,y,z) = readLine().split(" ").map{ it.toInt() }
        trees[x][y].add(z)
    }

    // 전체 나무의 수 = 0
    var treeCount = 0
    // k 년 만큼 반복한다.
    for(age in 0 until k){
    // 봄 : 나이가 어린 나무부터 나이만큼 쳐먹는다 -> 자신의 나이만큼 못먹은 애들은 죽는 애들 리스트로 추가한다.
        for(i in 0 until n){
            for(j in 0 until n){
                trees[i][j].sortedWith(compareBy({it}))
                for(target in trees[i][j].indices){
                    if(map[i][j] >= trees[i][j][target]){
                        trees[i][j][target]++
                    } else {
                        deadTrees[i][j].add(trees[i][j].poll())
                    }
                }

                // 여름 : 죽은 나무들 list -> 나무들의 third / 2 를 더한다. += poll / 2
                for(target in deadTrees[i][j].indices){
                    map[i][j] += deadTrees[i][j].poll() / 2
                }
                // 가을 : 8개의 dx dy에 나이가 1인 나무를 생성한다.  trees.add 8개 한다 inbound내에서
                for(target in trees[i][j].indices){
                    if(trees[i][j][target] % 5 == 0){
                        for(dir in dx.indices){
                            val nx = i + dx[dir]
                            val ny = j + dy[dir]
                            if(isInBound(nx,ny)){
                                trees[nx][ny].add(1)
                            }
                        }
                    }
                }
            }
        }
        // 겨울 : 땅에 양분을 추가한다
        for(i in 0 until n){
            for(j in 0 until n){
                map[i][j] += injection[i][j]
            }
        }
    }
    // tree의 전체 갯수 
    for(i in 0 until n){
        for(j in 0 until n){
            answer += trees[i][j].size
        }
    }
    print(answer)
}

fun isInBound(x: Int, y: Int): Boolean{
    return (x in 0 until n) && (y in until n)
}