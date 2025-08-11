#include <csdio>
#include <vector>

using namespace std;

void fillFrequencyTable(const vector<int> &data, int n, vector<int> &table){
    table.clear();
    table.resize(MAX_SERIAL_NUMBER+1,0);

    for(int i = 0; i<n;i++){
        int serial = data[i];
        table[serial] += 1;
    }
}

vector<int> getUniqueElements(const vector<int> &data, int n){
    //  유일한 원소들 배열, 비어있는 벡터 생성
    vector<int> ret;
    // data에 대한 빈도수 테이블을 계산한다.
    vector<int> table;
    fillFrequencyTable(data, n , table);
    for(int number = 1; number <= MAX_SERIAL_NUMBER;number++){
        // 셀 수 있는 모든 시리얼 넘버에 대해 차례로 조회한다.
        if(table[number] == 1){
            ret.push_back(number);
        
        }
    return ret;
    }
    
}
int main(){
    int n;
    scanf("%d", n);

    vector<int> data = vector<int>(n);

    for(int i = 0; i<n;i++){
        scanf("%d", &data[i]);
    }
    const vector<int> answer = getUniqueElements(data,n);

    // 각 원소들을 출력한다.
    for(int i = 0; i<answer.si;i++){
        if(i>0){
            printf(" ");
        }
        printf("%d",answer[i]);
    }
    return 0;   
}