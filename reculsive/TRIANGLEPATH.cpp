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