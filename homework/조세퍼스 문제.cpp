#include <stdio.h>
#include <string.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <time.h>


using namespace std;

class Player{
    public:
    int indexl
    Player(int index = 0){
        this->index = index;
    }
};

/**
n : 플레이어의 수
m 매턴마다 건너뛰는 사람의 수
players 좌석에 앉아있는 순서대로 주어지는 플레이어 정보
return
**/
vector<Player> getDeadPlayersList(int n, int m, const vector<Player> &players){
    // 현재 게임에서 제외된 플레이어들의 리스트
    vector<Player> deadPlayers;

    queue<Player> que;
    for(int i = 0 ; i < n; i+=1){
        que.push(players[i]); // 1 2 3 4 5 6 7
    }
    for(int i = 0 ; i < n; i+=1){
        // (m-1)명의 사람은 건너뛴다.
        int jump = 1+ (m-1) % que.size();
        for(int j = 0 ; j <jump-1; j+=1){
            Player p = que.front();
            que.pop();
            que.push(p);  // 2 3 4 5 6 7 1 -> 3 4 5 6 7 1 2
        }

    // m 번째 사람은 게임에서 제외한다.
    Player dead = que.front();
    que.pop();
    // 제외 리스트에 추가한다.
    deadPlayers.push_back(dead);
    }
return  deadPlayers;

}
void testcase(int caseIndex){
    int n, m;
    scanf("%d %d",&n, &m);

    vector<Player> players;
    for(int i = 0; i<n;i++){
        players.push_back(Player(i+1));
    }
    vector<Player> deadPlayers = getDeadPlayersList(n,m,players);
    for(int i = 0;i<n;i++){
        if(i >0){
            printf(" ");
        }
        Player p = deadPlayers[i];
        printf("%d", p.index);
    }
    printf("\n");
}


int main(){
    int caseSize;
    scanf("%d", &caseSize);
    for(int caseIndex = 1; caseIndex <= caseSize; caseIndex +=1){
        testcase(caseIndex);
        return 0;
    }
}