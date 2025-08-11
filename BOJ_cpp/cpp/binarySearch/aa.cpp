#include <iostream>
#include <vector>


using namespace std;

int main(){
    vector<int> arr;
    
    int n,m;
    
    cin >> n >> m;
    
    // 입력
    while(n--){
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }
    
    for(int i = 0; i < n; i++){
        if(arr[i] == m){
            cout << arr[i];
        }
    }
    return 0;
}
