#include <iostream>
#include <vector>
#include <time.h>
#include <algorithm>

using namespace std;

const int INT_MAX = 987654321;
int minTry;
int N,K;


//  역순으로 정렬
vector<int> flip(vector<int> out, int start){
    reverse(out.begin()+start,out.begin()+start+K);
    return out;
}

// 오름차순이면 true 아니면 false
bool isAscending(vector<int> list){
    for(int i = 0; i < list.size()-1; i++){
        // 이전 원소가 더 크다면
        if(list[i] > list[i+1]){
            return false;
        }
    }
    return true;
}

void process(vector<int> list, int K){
    minTry = 0;
    

    // 뒤집기를 시도한 벡터
    vector<int> out;    
    vector<int>::iterator it;

    int cnt = 0;
    int sign = 0;

    // index가 0번으로 시작하면 시도하지 않는다. 따라서 0번을 먼저 처리한다.
    if(sign == N-K){
        if(!isAscending(list)){
                list = flip(list,0);
                cnt++;
                for(it = list.begin(); it != list.end(); it++){
                    cout << *it << " ";
                }
                cout << endl;
            }
    }
    while(sign != N-K+1){
        for(int j = N-K; j >=sign; j--){
            if(!isAscending(list)){
                // cout << "Not Ascending";
                // cout << "index" << i << endl;
                list = flip(list,j);
                cnt++;
                for(it = list.begin(); it != list.end(); it++){
                    cout << *it << " ";
                }
                cout << endl;
            }
        }
        sign++;
    }
    cout << cnt << endl;
}

int main(){
    clock_t start = clock();

    vector<int> cards;
    cin >> N >> K;
    // 카드 입력받기
    for (int i = 0; i < N; i++) {
        int temp;
        cin >> temp;
        cards.push_back(temp); 
    }
    process(cards, K);

    clock_t end = clock();
    printf("실행시간: %lf\n", (double)(end-start)/CLOCKS_PER_SEC);
    return 0;
}
