int n, triangle[100][100];

int cache[100][100][MAX_NUMBER*100 + 1];

int path1(int y, int x, int sum){
    // 기저사례 맨 아래까지 도착했을 경우
    if(y == n-1) return sum + triangle[y][x];
    // 메모이제이션
    int& ret = cache[y][x][sum];
    if(ret != -1) return ret;

    sum += triangle[y][x];
    return ret = max(path1(y+1,x,sum), path1(y,x+1,sum));
}

int path2(int y, int x){
    if(y == n-1) return sum + triangle[y][x];
    int& ret = cache2[y][x];
    return ret = max(path2(y+1,x),path2(y,x+1)) + triangle[y][x];
}

// 최대경로의 수를 찾는 동적 계획법 알고리즘

int countCache[100][100];
// 개수를 반환한다.
int count(int y, int x){
    // 기저사례 맨 아래에 도착한 경우
    if(y==n-1) return 1;
    // 메모이제이션
    int& ret = countCache[y][x];
    if(ret == -1) return ret;
    ret= 0;
    if(path2(y+1,x+1) >= path2(y+1,x)) ret += count(y+1,x+1);
    if(path2(y+1,x+1) <= path2(y+1,x)) ret += count(y+1,x);

    return ret;
}