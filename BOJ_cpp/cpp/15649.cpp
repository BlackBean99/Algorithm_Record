#include <iostream>

using namespace std;
int n;
int b,c;
int main(void) {
    cin >> n;
    int a[1000000];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> b >> c;
    long long teachers = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] - b < 0) {
            teachers++;
        }
        else{
            // 총 감독관
            a[i] = a[i] - b;
            teachers++;
            if(a[i] % c == 0)
                teachers += a[i] / c;
            else
                teachers += a[i] / c + 1;
        }
    }
    cout << teachers;
}