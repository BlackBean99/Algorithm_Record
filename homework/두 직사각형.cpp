#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int get_area(int la, int ra, int ta, int ba, int lb, int rb, int tb, int bb){
    // 겹치는 영역이 존재한다는 가정
    // 직사각형의 y축 위치에 따라 달라지는 값들은 abs 절댓값을 출력하면 된다.
    // 첫번째 사각형이 왼쪽에 있을때
    if(min(la,ra)<min(lb,rb)){
        return abs((max(la,ra)-min(lb,rb))*(max(ta,ba)-min(tb,bb)));
    }
    // 첫번째 사각형이 오른쪽에 있을 때
    else if(min(la,ra)>min(lb,rb)){
        return abs((max(lb,rb)-min(la,ra))*(max(ta,ba)-min(tb,bb)));
    }
    // 첫번째, 두번째 사각형의 x좌표가 똑같을 때
    else{
            return abs(min((ra-la),(rb-lb))*min((ta-bb),(tb-ba)));
    }
}

void test_case(){
    int ax, ay, bx, by;
    int px, py, qx, qy;

    scanf("%d %d %d %d",&ax,&ay,&bx,&by);
    scanf("%d %d %d %d",&px,&py,&qx,&qy);

    int la, ra, ba, ta;  //직사각형 a
    la = min(ax, bx);
    ra = max(ax, bx);
    ta = max(ay, by);
    ba = min(ay, by);

    int lb, rb, bb, tb;  //직사각형 b
    lb = min(px, qx);
    rb = max(px, qx);
    tb = max(py, qy);
    bb = min(py, qy);

    int answer = get_area(la, ra, ta, ba,
                          lb, rb, tb, bb);

    printf("%d\n",answer);
}

int main(){
    int t;
    scanf("%d", &t);

    for(int i = 0; i<t; i++){
        test_case();
    }

    return 0;
}