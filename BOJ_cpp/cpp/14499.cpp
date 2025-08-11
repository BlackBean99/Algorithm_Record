#include <iostream>
#include <queue>
#define MAX 20

using namespace std;

int n, m;
int x,y;
int k;

int MAP[MAX][MAX];
// 동 서 남 북
int dx[] = { 0, 0, -1, 1 };
int dy[] = { 1, -1, 0, 0 };
int Dice[7] = {0};

vector<int> Cmd;

void Input()
{
    cin >> n >> m >> x >> y >> k;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> MAP[i][j];
        }
    }
    for (int i = 0; i < k; i++)
    {
        int a; cin >> a;
        a = a - 1;
        Cmd.push_back(a);
    }
}

void rollDice(int d){
    int d1, d2, d3, d4, d5, d6;
    d1 = Dice[1], d2 = Dice[2], d3 = Dice[3];
    d4 = Dice[4], d5 = Dice[5], d6 = Dice[6];

    if (d == 0)
    {
        Dice[1] = d4;
        Dice[4] = d6;
        Dice[6] = d3;
        Dice[3] = d1;
    }
    else if (d == 1)
    {
        Dice[4] = d1;
        Dice[6] = d4;
        Dice[3] = d6;
        Dice[1] = d3;
    }
    else if (d == 2)
    {
        Dice[1] = d5;
        Dice[2] = d1;
        Dice[6] = d2;
        Dice[5] = d6;
    }
    else if (d == 3)
    {
        Dice[5] = d1;
        Dice[1] = d2;
        Dice[2] = d6;
        Dice[6] = d5;
    }
}
void Solve(){
    for (int i = 0; i < Cmd.size(); i++) {
        int nx = x + dx[Cmd[i]];
        int ny = y + dy[Cmd[i]];
        int d = Cmd[i];

        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
        rollDice(d);
        // 현재 지금 위치가 0이면
        if(MAP[nx][ny] == 0) MAP[nx][ny] = Dice[6];
        else{
            Dice[6] = MAP[nx][ny];
            MAP[nx][ny] = 0;
        }
        cout << Dice[1] << endl;
        x = nx;
        y = ny;
    }
}
int main(void) {
    Input();
    Solve();
}