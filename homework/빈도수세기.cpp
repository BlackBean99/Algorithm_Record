#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main(){
    int N;
    cin >> N;
    map<int, int> frequencyMap;

    for(int i = 0; i < N; i++){
        int tmp;
        cin >> tmp;
        frequencyMap[tmp]++;
        printf("%d %d\n",frequencyMap.size(),frequencyMap[tmp]);
    }
    return 0;
}