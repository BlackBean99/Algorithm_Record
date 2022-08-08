#include <iostream>

using namespace std;
class Board{
    public:
        int getLowByIndex(int index){
            int low;
            low = (index % 9);
            if(low == 0){
                low = 9;
            }
            return low;
        }
        int getColByIndex(int index){
            int col;
            if(index /9 == 0){
                col = index / 9;
            }
            col = index / 9;
            return col;
        }
        int getGroupByIndex(int index){
            int low = getLowByIndex(index);
            int col = getColByIndex(index);
            int group = getGroupByPosition(low, col);
            return group;
        }

        int getGroupByPosition(int low, int col){
            int group = (col/3 + 1) * (low/3);
            return group;
        }

};

int main(){
    int index;
    cin >> index;

    int low, col, group;
    Board board = Board();
    low = board.getLowByIndex(index);
    col = board.getColByIndex(index);
    group = board.getGroupByIndex(index);

    cout << low << " " << col << " " << group << endl;
    return 0;
}