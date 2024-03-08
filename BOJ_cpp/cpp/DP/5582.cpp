#include <iostream>
#include <vector>

using namespace std;

int main(void){
    string s1,s2;

    cin >> s1;
    cin >> s2;
    int ans = 0;

    vector<vector<int> > vec(s1.length() + 1, vector<int>(s2.length() + 1,0));

    for (int i = 1; i < s1.length(); ++i) {
        for (int j = 1; j < s2.length(); ++j) {
            if(s1[i-1] == s2[j-1]){
                vec[i][j] = vec[i-1][j-1] + 1;
                ans = max(ans, vec[i][j]);
            }
        }
    }
    cout << ans;
}