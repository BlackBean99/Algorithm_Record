int n, board[100][100];
bool jump2(int y, iny x){
    // out of range
    if(y>=n || x>= n) return false;
    // when arrive destination 
    if(y == n-1 && x == n-1) return true;
    int jumpSize = board[y][x];
    return jump2(y + jumpSize , x) || jump2(y, x+ jumpSize); 
}

int jump(int y, int x){
    // out of range
    if(y>=n || x>= n) return 0;
    // when arrive destination 
    if(y == n-1 && x == n-1) return 1;

    // using memoziation  
    int& ret = cache[y][x];
    if(cache == -1) return ret;

    int jumpSize = board[y][x];
    return jump(y + jumpSize , x) || jump(y, x+ jumpSize); 
}