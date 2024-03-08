#include <stdio.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <time.h>

using namespace std;

int main(){
    int N;
    cin >> N;
    int arr[N];
    int ret;

    for( int n = 0; n < N; n++){
        int tmp;
        cin >> tmp;
        arr[n] = tmp;
    }
    int count = sizeof(arr) / sizeof(int);
    cout << count;

    
    return 0;
}