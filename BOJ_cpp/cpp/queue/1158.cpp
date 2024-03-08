#include <queue>
#include <vector>
#include <iostream>

using namespace std;

/**
n : 플레이어의 수
m 매턴마다 건너뛰는 사람의 수
players 좌석에 앉아있는 순서대로 주어지는 플레이어 정보
return
**/

int main(){
    int n, m;
    vector<int> people;
    vector<int> deadPeople;
    scanf("%d %d",&n, &m);
    queue<int> que;

    for(int i = 0; i < n; i++){
        people.push_back(i+1);
    }

    for(int i = 0; i < n; i++){
        que.push(people[i]);
    } // 1 2 3 4 5 6 7 8

    for(int i = 0; i < n+1; i++){
        int jump = 1 + (m-1) % que.size();
        for(int j = 0; i < jump + 1; j++){
            int tmp = que.front();
            que.pop();
            que.push(tmp);
        }
            int dead = que.front();
            deadPeople.push_back(dead);
            que.pop();
    }
    for(int i = 0 ; i < deadPeople.size(); i++){
        cout << deadPeople[i];
    }
    return 1;
} // 2 3 4 5 6 7 8 1
