
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;


void filter(int n,int m){
    vector<int> arr;
    // arr = init(arr);
    arr.push_back(0);
    arr.push_back(1);
    for(int i = 2 ; i < n+1;i++){
        arr.push_back(i);
    }

    int cnt = 0;
    for(int i = 2; i < n+1; i++){
        //  i의 k배수를 제거
        if(arr[i] != 0){
            int k = 1;
            while((i * k) < n+1){
                // cout << i*k << " : " << cnt << endl;
                if(arr[i*k] == 0){
                    k++;
                    continue;
                }
                arr[i*k] = 0;
                k++;
                cnt++;
                if(m == cnt){
                    cout << i*(k-1) << endl;
                    break;
                };
            }
        }
        if(m == cnt){
            break;
            };
    }
}

int main(){
    int n, m;
    cin >> n >> m;
    filter(n,m);
    return 0;
}