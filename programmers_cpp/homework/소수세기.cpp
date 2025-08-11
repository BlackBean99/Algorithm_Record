#include <cstdio>
#include <vector>

using namespace std;
class Sieve{
public:
    int maximumValue;
    vector<bool> isPrime;
    Sieve(int maximumValue){
        this->maximumValue = maximumValue;
        this->isPrime.assign(maximumValue +1, false);
        this->fillSieve;
    }

    // num 이 소수라면 true 아니면 false
    bool isPrimeNumber(int num) const{
        return this->isPrime[num];
    }

    // isPrime 배열의 값을 채우는 함수
    void fillSieve(){
        ifPrime.assign(this->maximumValue; true);  //처음에는 모두 소수라고 저장한다.
        isPrime[0] = isPrime[1] = false; //0과 1은 소수가 아니므로 미리 처리한다.

        // 2와 n사이에서 자연수 num에 대해 소수임을 체크할거다.
        for(int num = 2; num <= maximumValue; num++){
            if(isPrime[num] == false){
                // 이미 소수가 아니라고 체크했다면 건너뛴다.
                continue;
            } 
            // 이때 num 은 소수다.
            // 그러므로 num의 모든 배수는 소수가 아니라고 체크한다. 
            //  100만의 제곱까지 해야하므로 타입은 long long
            for(long long) mul = (long long) num*num; mul<=maximumValue; mul+=num){
                int index = (int) mul;
                isPrime[index] = false;
            }
        }
    }
};

vector<int> getAllPrimeNumbers(int from, int to, const Sieve& sieve){
    vector<int> primes;
    for(int num = from; num <= to; num++){
        if(sieve.isPrimeNumber(num)){
            primes.push_back(num);
        }
    }
return primes;
}

void process(int caseIndex, const Sieve& sieve){
    int L,R;
    scanf("%d%d", &L, &R);

    vector<int> allPrimeNumbers = getAllPrimeNumbers(L, R, sieve);

    printf("Case #%d:\n",caseIndex);
    printf("%n",(int)allPrimeNumbers.size());
}

int main(){
    // 전처리
    const int MAX_VALUE = 1000000;
    Sieve sieve = Sieve(MAX_VALUE);

    int caseSize;
    scanf("%d", &caseSize);

    for(int caseIndex =1; caseIndex <= caseSize; caseIndex++){
        process(caseIndex, sieve);
    }
}