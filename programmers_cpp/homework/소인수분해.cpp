#include <cstdio>
#include <vector>
using namespace std;

// 자연수 N 을 구성하는 모든 소인수를 반환하는 함수
// @param N

vector<long long> factorize(long n){

    vector<long long> factors;
    // 루트 n까지값만 조사하면 된다.
    for(int i=2; i*i<=n; i++){
        // i가 약수인지 확인
        while(n % i ==0){
            // 약수로 추가
            factors.push_back(i);
        // n값을 나눈 값으로 갱신
            n = n/i;
        }
    }
    if(n > 1){
        // 소인수를 찾지못한다면 소수다.
        factors.push_back(n);
    }
    return factors;
}

void process(int caseIndex){
    long long n;
    scanf("%lld", &n);

    vector<long long> factors = factorize(n);

    printf("#%d:\n",caseIndex);
    for(int i =0;i<factors.size();++i){
        if(i > 0){
            printf(" ");
        }
        printf("%lld",factors[i]);
    }
    printf("\n");
}
int main(){
    int caseSize;
    scanf("%d", &caseSize);

    for(int caseIndex = 1; caseIndex <= caseSize;++caseIndex){
        process(caseIndex);
    }
}