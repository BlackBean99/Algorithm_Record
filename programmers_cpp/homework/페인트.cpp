
#include <cstdio>

const int MAX_SEAT_NUMBER = 1000;
const int MAX_COLOR_NUMBER = 100;

// 좌석들을 ㅐ한번 색칠하는 이벤트에 대한 정보
class Painting{

    public:
        int left;
        int right;
        int color;

        Painting(){}
        Painting(int left, int right, int color){
                this->left = left;
                this->right = right;
                this->color = color;
        }
};

// data 배열에 등장한 번호들에 대한 빈도수 테이블을 채우는 함수이다.
// table[i] data 배열에서 i가 등장한 횟수

void fillFrequencyTable(int data[], int n, int table[]){
    // table 배열을 0으로 초기화
    for(int i = 0 ; i < MAX_COLOR_NUMBER;i++){
        table[i] = 0;
    }
    // 값을 인덱스로 채워넣어 빈도수를 계산한다.
    for(int i = 0; i < n ; i++){
        int color = data[i];
        table[color]++;
    }
}


void solve(int n, int m, const Painting *paintings){
    int *seats = new int[n];
    for(int i=0;i < n;i++){
        seats[i] = 0;
    }

    // 색칠 정보들이 주어진 순서대로 각 좌석을 색칠한다.
    for(int i=0;i<m;i++){
        const Painting &p = paintings[i];

        // 각 페인팅 정보마다 좌석의 색을 업데이트 해준다.
        for(int j=p.left;j <= p.right;j++){
            seats[j] = p.color;
        }
    }
    // 모든 색칠을 완료한 이후의 색상 정보를 사용하여
    // 모든 색상에 대한 빈도수 테이블을 계산한다.
    int *table = new int[MAX_COLOR_NUMBER];
    fillFrequencyTable(seats, n, table);

    int minColor = seats[0];
    int maxColor = seats[0];

    for(int color = 0; color < MAX_COLOR_NUMBER; color++){
        if(table[color] == 0) //한번도 등장하지 않은 색깔
            continue;
        if(table[minColor] > table[color]){
            minColor = color;
        }
        if(table[maxColor] < table[color]){
            maxColor = color;
        }
    }
    printf("%d\n", maxColor);
    printf("%d\n", minColor);
}



int main(){
    int n, m;
    scanf("%d %d", &n, &m);
    Painting* paintings = new Painting[n];
    for(int i = 0; i <m ; i++){
        scanf("%d", &paintings[i].left);
        scanf("%d", &paintings[i].right);
        scanf("%d", &paintings[i].color);
        //  좌석의 번호는 1번부터 시작되므로, 0 ~(n-1) 범위로 맞추기 위하여 1씩 빼준다.
        paintings[i].left -=1;
        paintings[i].right -=1;
    }
    solve(n,m,paintings);

    return 0;
}