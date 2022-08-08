#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

// 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
// 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
// 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
// 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

// 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
// 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

int main(){

    // cin, cout 속도 향상을 위해 동기화 해제   
    ios_base::sync_with_stdio(false);
    // cin.tie(NULL), cout.tie(NULL);


    int countLecture;
    cin >> countLecture;
    map<int, int> timeTable;
//  데이터 입력
    for(int i=0; i<countLecture; i++){
        int tmp1, tmp2;
        cin >> tmp1;
        cin >> tmp2;
        timeTable[tmp1] = tmp2;
    }

    int index = 0;
    int startIndex = 0;
    int endIndex = 0;
    map<int, int>::iterator it;

    for(auto it = timeTable.begin(); it!=timeTable.end(); it++){
        cout << it->first << ", " << it->second << endl;
    }

}