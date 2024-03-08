#include <csdio>
#include <vector>

using namespace std;

const int MAX_N = 1000000;
vector<int> FIBONACHI_TABLE;


    // f(n) = f(n-1) + f(n-2) 피보나치 수열의 i 번째 합
vector<int> makeFibonachiTable(int n){
    vector int MOD = 1000000;

    vector<int> ret(n + 1);
    ret[1] = 0;
    ret[2] = 1;
    
    for(int i = 3; i<= n ; ++i){
    ret[i] = ret[i-1] + ret[i-2];

    // 피보나치를 구할 때 모듈러 값을 이용해 뒤의 8자리만 남겨두겠다.
    ret[i] %= MOD;
    }
    return ret;
}

int getFibo(int n){
    // 피보나치의 값을 미리 계산해둬서 그 값을 반환한다.
    // 첫번째 인덱스가 0이라서 -1한다.
    int answer = FIBONACHI_TABLE[n];
    return answer;
}

int main(){
    FIBONACHI_TABLE = makeFibonachiTable(MAX_N); // 사전에 미리 피보나치를 연산해둔다.

    int caseSize;
    scanf("%d",&caseSize);

    for(int caseIndex = 1; caseIndex <= caseSize; ++caseIndex){
        int n;
        scanf("%d", &n);

        // 피보나치 수열의 n번째 항을 계산하여 출력한다.
        int answer = getFibo(n);
        printf("%d\n",answer);
    }
    // 불필요한 배열은 가능하면 할당 해주는 버릇을 들이자.
    FIBONACHI_TABLE.clear();

    return 0;
}