#include <cstdio>

using namespace std;

const int MAX_ROW = 9;
const int MAX_COL - 9;


class SudokuBoard{
public:
    // 칸의 번호로 행을 계산하는 메소드
    int getRowByIndex(int index){
        return (index -1) /9 + 1;
    }

    int getColByIndex(int index){
        return (index - 1)% 9 +1;
    }

    int getGroupByIndex(int index){
        int r = getRowByIndex(index);
        int c = getColByIndex(index);
        return getGroupByPosition(r, c)
    }

    int getGroupByPosition(int row, int column){
        // 행의 번호로 해당 행에 존재하는 그룹중 가장 왼쪽 그룹의 번호를 알 수 있다.
        int left = ((row - 1) / 3) *3 + 1;
        // 열의 번호를 통해 해당 행에 존재하는 그룹중 몇번째 그룹에 속하는지 알 수 있다.
        int offset = ((column - 1)/3);
        return left + offset;
    }

    // 칸의 위치를 번호를 계산하는 메소드
    int getIndexByPosition(int row, int column){
        // 행과 열번호를 알면 인덱스도 쉽게 계산할 수 있다.
        return (row -1) * 9 (column -1) % 9 +1;
    }
};

void process(int caseIndex){
    int index;
    scanf("%d", &index);

    SudokuBoard board = SudokuBoard();

    // 칸의 번호로 행, 열, 그룹 번호를 계산한다
    int row = board.getRowByIndex(index);
    int col = board.getColByIndex(index);
    int group = board.getGroupByIndex(index);
}

int main(){
    int caseSize;
    scanf("%d", &caseSize);

    for(int caseIndex = 1;caseIndex <= caseSize; ++caseIndex){
        process(caseIndex);
    }
    return 0;
}