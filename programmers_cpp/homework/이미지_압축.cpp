#include<time.h>
#include<iostream>
#include<set>
#include<vector>
#include<algorithm>
#include<cmath>

using namespace std;


/**
N : 입력 image 픽셀의 수
W : 에러를 계산하는 가중치
*/
int N, W;
vector<vector<int>> cache(50, vector<int>(256));
vector<vector<int>> backtrack(50, vector<int>(256));
vector<int> image(50);
vector<int> comp{1, 86, 172, 256};

// 최적부분 구조를 이용한방법을 사용 압축 비용의 최소값을 계산해나간 값을 cache벡터에 저장하고, 차후에 최소값 계산으로 사용된 압축 결과를 다시 확인하기 위해
// 수열의 인덱스별로 해당 압축값으로 압축되었을때 이전 인덱스의 압축값을 backtrack벡터에 저장한다.
void process(){
    // 첫번째 순서만 따로 처리를 해야한다.
    for (int i = 0; i < 4; i++) {
        cache[0][comp[i]] = abs(comp[i] - image[0]) + W*2;
    }
    for (int i = 0; i < N; i++) {
        for(int curr = 0; j<4;j++){
            int min_value = INF;
            for(int prev = 0; j<4;j++){
                int tmp_value;
                // 이전 픽셀과 같은 경우 0을 삽입해야한다.
                // 이때 계산되는 길이는 1이므로 아래와 같이 계산한다.
                if(curr == prev){
                    tmp_value = cache[i-1][prev] + abs(comp[curr] - image[prev]) + W*1
                }
                // 이전 픽셀과 다른 경우
                // 이때의 길이는 1을 더하고 나서 그 뒤에 코드를 붙이기 떄문에 길이가 3이다.
                else{
                    tmp = cache[i-1][prev] + abs(comp[curr] - image[prev]) + W*3;
                }
                // 최적화
                // 갱신하고 이전 기록을 저장하는 BackTracking에 저장한다.
                if(tmp_value < min_value){
                    min_value = tmp_value;
                    backtrack[i][comp[cur]] = min_value;
                }
            }
            cache[i][comp[curr]] = min_value;
        }
    }
}


// 레벨에 해당하는 2bit code 문자열을 반환한다.
string getCompCode(int level) {
    if (level == 1) {
        return "00";
    } else if (level == 86) {
        return "01";
    } else if (level == 172) {
        return "10";
    } else{
        return "11";
    }
}

int main() {
    clock_t start = clock();

    // N, W, N길이의 이미지 픽셀 값을 입력밭는다.
    cin >> N >> W;
    for (int i = 0; i < N; i++) {
        cin >> image[i];
    }

    // 풀이 함수
    process();

    // dp 함수에서 저장한 cache벡터에서 N길이 만큼 압축했을때 압축값별 최소값을 찾아서 정답(최소압축비용)을 구한다.
    int minCost = 987654321;
    int lastComp;
    for (int i = 0; i < 4; i++) {
        if (minCost > cache[N - 1][comp[i]]) {
            minCost = cache[N - 1][comp[i]];
            lastComp = comp[i];
        }
    }
    cout << minCost << endl;

    // 최소압축비용을 구하는 과정에서 마지막 인덱스의 압축값을 알 수 있다. 이를 이용해서 backtrack벡터를 백트랭킹하여, 최종적인 압축값들을 구하여
    // compression벡터에 저장한다. backtrack벡터는 이전 압축값을 저장하므로, 인덱스 1까지만 순회한다.
    vector<int> compression;
    compression.push_back(lastComp);
    for (int i = N - 1; i >= 1; i--) {
        compression.push_back(backtrack[i][lastComp]);
        lastComp = backtrack[i][lastComp];
    }
    // 백트래킹으로 구한 압축값들이므로 원래 순서대로 바꾸기 위해 reverse한다.
    std::reverse(compression.begin(), compression.end());

    // 구한 compression함수를 순회하면서 압축값을 2bit code로 변환하면서 출력한다.
    // 첫 압축값은 이전 압축값이 없으므로 바로 변환해서 출력
    cout << getCompCode(compression[0]);
    for (int i = 1; i < N; i++) {
        // 이전 압축값과 값으면 0만
        // 다르면 1과 함께 2비트 코드를 출력한다.
        if (compression[i] == compression[i - 1]) {
            cout << "0";
            continue;
        } else {
            cout << "1";
        }

        // 다른 압축값인 경우에 원본 2bit code도 출력한다.
        cout << getCompCode(compression[i]);
    }
    cout << endl;


    clock_t end = clock();
    printf("실행시간: %lf\n", (double)(end-start)/CLOCKS_PER_SEC);
    return 0;
}