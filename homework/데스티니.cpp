#include<iosteam>
using namespace std;

// 구조체 선언
class Point2D{
    public:
        Point2D(int x=0, int y =0){
            this-> = x;
            this -> = y;
        }


    // 거리 절댓값을 계산
        int getSqaredDistanceTo(const Point2D &target) const{
            int dx = abs(this->x - targe.x);
            int dy = abs(this->y - target.y);
            return dx*dx + dy*dy;
        }
    // 루트를씌운 실제 거리를 계산
        double getDistanceTo(const Point2D &target) const{
            double sqd = (double) this->getSqaredDistanceTo(target);
            return sqrt(sqd);
        }
    };

int main(){
    int n;
    Point2D *points;

    scanf("%d", &n);
    points = new Point2D[n];

// 좌표 입력하기
    for(int i=0;i<n;i++){
        int x,y;
        scanf("%d %d", &x,&y);
    }

    int min_sqd = INT_MAX;
    int min_cnt=0;

    for(int i =0;i<n;i++){
        for(int j =0;j<i;j++){
            int sqd = points[j].getSqaredDistanceTo(points[j]);
            if(sqd < min_sqd){
                min_sqd = sqd;
                min_cnt = 1;
            } else if(sqd == min_sqd){
                min_cnt++;
            }
        }
    }
}