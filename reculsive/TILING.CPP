const int MOD = 1000000007;
int cache[102];

int tiling(int width){
    // 기저사례 남은 width가 없는경우
    if(width <= 1) return 1;
    // 메모이제이션
    int& ret = cache[width];
    if(ret != -1) return ret;

    return ret = (tiling(width -2) + tiling(width -1)) % MOD;
}