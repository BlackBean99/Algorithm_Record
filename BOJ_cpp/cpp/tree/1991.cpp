#include <bits/stdc++.h>

using namespace std;

int n;
char rc[100];
char lc[100];

void preorder(int cur){
    cout << char(cur+'A'-1);
    if(lc[cur] != 0) preorder(lc[cur]);
    if(rc[cur] != 0) preorder(rc[cur]);
}

void inorder(int cur){
    if(lc[cur] != 0) inorder(lc[cur]);
    cout << char(cur+'A'-1);
    if(rc[cur] != 0) inorder(rc[cur]);
}

void postorder(int cur){
    if(lc[cur] != 0) postorder(lc[cur]);
    if(rc[cur] != 0) postorder(rc[cur]);
    cout << char(cur+'A'-1);
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i = 1;i<=n;i++){
        char a,b,c;
        cin >> a >> b >> c;
        if(b != '.') lc[a-'A'+1] = b-'A'+1;
        if(c != '.') rc[a-'A'+1] = c-'A'+1;
    }
    preorder(1); cout << '\n';
    inorder(1); cout << '\n';
    postorder(1); cout << '\n';
}