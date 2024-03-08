#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int solution(vector<string> board) {
    int answer = 0;
    queue<pair<int,int> > Q;
    for(int i = 0; i < board.size(); i++){
        for(int j = 0; j < board[0].length(); j++){
            if(board[i].at(j) == 'R'){
                Q.push(make_pair(i,j));
            }
        }
    }
    while(!Q.empty()){
        int curX = Q.front().first;
        int curY = Q.front().second;
        Q.pop();
        for(int i = 0; i < 4; i++){
            int nx = curX +dx[i];
            int ny = curY +dy[i];
            if(nx < 0 || nx >= board.size() || ny < 0 || ny >= board[0].length()) continue;
            if(board[nx].at(ny) == 'D') continue;
            Q.push(make_pair(nx,ny));
            board[nx][ny] = 'D'; // mark as visited
            answer++;
        }
    }

    return answer;
}

int main(void){
    vector<string> board;
    board.push_back("...D..R");
    board.push_back(".D.G...");
    board.push_back("....D.D");
    board.push_back("....D.D");
    board.push_back("D....D.");
    board.push_back("..D....");
    int answer = solution(board);
    cout << answer << endl;
}
