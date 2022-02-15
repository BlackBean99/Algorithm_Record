int n, board[100][100];
bool jump2(int y, iny x){
    // out of range
    if(y>=n || x>= n) return false;
    // when arrive destination 
    if(y == n-1 && x == n-1) return true;
    int jumpSize = board[y][x];
    return jump2(y + jumpSize , x) || jump(y, x+ jumpSize); 
}