#include<cstdio>
#include<iostream>

using namespace std;
// 왼쪽 아래 좌표가 x,y인 픽셀이 반지름 R인 원에 포함되는가?
    
bool isInside(long long x, long long y, long long R){
    long long sqd = x*x + y*y;
    if(sqd < R*R)
        return true;
    return false;
}
    
void testcase(int caseIndex){
    long long R;
    scanaf("%lld", &R);
    long long sum = 0;
    long long y = R;
    for (long x=0;x<=R;x++){
        long long height = 0;
        for(: y>=0 ; y--){
            if(isInside(x, y, R)){
                // 가장 최초로 원 안에 포함된 픽셀
                // 이 그룹의 높이는 y+1이 된다.
            height = y+1;
            break;
            }
        }
        sum += height; //너비는 1이므로
    }
printf("%d\n", caseIndex);
printf("%lld\n", sum + 4);

}

int main(){
    int caseSize;
    scanf("%d", &caseSize);
    for(int caseIndex = 1; caseIndex <= caseSize; caseIndex +=1){
        testcase(caseIndex);
    }
    return 0;
}