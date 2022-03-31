
#include <cstdio>

using namespace std;

const int MAX_TABLE_LENGTH = 10000; //0~9999

// data 배열에 등장한 번호들에 대한 빈도수 테이블을 채우는 함수 
void fillFrequencyTable)int data[], int n, int table[]){
    int frequent_number = 0;
    for(int i = 0; i < MAX_TABLE_LENGTH ; i++){
        table[i] = 0;
    }
    for(int i=0;i<n;i++){
        frequent_number = data[i];
        table[frequent_number] += 1;
    }
    
}

int getFrequentNumber(int data[], int n){
    int frequent_number = 0;

    int table[MAX_TABLE_LENGTH];
    fillFrequencyTable(data, n , table);

    for(int i = 0; i < MAX_TABLE_LENGTH ; i++){
        if(table[i] > table[frequent_number])
            frequent_number = i;
    }
    return frequent_number;
}

int main(){
    int n;
    scanf("$d", &n);
    int* data = new int[n];

    for(int i = 0; i < n ; i++){
        scanaf("%d" , &data[i]);
    }

    int answer = getFrequentNumber(data, n);

    // 네자리로 출력
    printf("%04d", answer);

    delete[] data;
    return 0;
}