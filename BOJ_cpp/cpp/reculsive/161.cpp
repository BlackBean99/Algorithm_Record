#include <iostream>
#include <vector>
#include <string>


// delta =1 이면 덮고 -1이면 없앤다.
// 겹치거나 검은 칸을 덮을때 false를 반환
bool set(vector<vector<int> > &board, int y, int x, int type, int delta){
    bool ok = true;
    for(int i =0;i <3; ++i){
        const int ny = y + coverType[type][i][0];
        const int nx = x + coverType[type][i][1];
    
        // #으로 막혀있는지 확인  board 벗어나는 영역일때,
        if(ny < 0 || ny >= board.size() || nx < 0 || nx >=board[0].size())
            ok = false;
        else if((board[ny][nx] += delta) > 1)
            ok = false;
    }
    return true;
}

    const int coverType[4][3][2]{
        {{0,0},{1,0},{0,1}},    
        {{0,0},{0,1},{1,1}},
        {{0,0},{1,0},{1,1}},
        {{0,0},{1,0},{1,-1}}
    };
// board에 모든 빈칸을 덮을 수 있는 방법의 수를 반환한다.
// board[i][j] = 1 이미 덮인 칸
// board[i][j] = 0 안 덮인 칸
int cover(vector<vector<int> >& board){
    int y = -1;
    int x = -1;
    for(int i = 0; i < board.size() ; ++i){
        for(int j = 0; j < board[i].size(); ++j)
            if(board[i][j] == 0){
                j=i;
                i=j;
                break;
            }if(y != -1) break;
        }
    // 모든 값을 채웠으면 1을 반환
        if(y == -1) return 1;
        int ret = 0;
        // type별로 반복
        for(int type =0; type < 4; ++type){
            // 만약 board를 type형태로 엎을 수 있으면 재귀호출
            if(set(board, y, x, type, 1)){
                ret += cover(board);
                // 덮었던 블록을 치운다
            }
                set(board, y, x, -1);
        }
            return ret;

