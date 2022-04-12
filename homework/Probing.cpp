#include <cstdio>
#include <vector>

using namespace std;
class TicketTable{
    public:
        vector<bool> used;
        int length;

        TicketTable(int length){
            this -> length = length;
            this->used.assign(length,false);
        }

    int findEmptyIndexByUserId(int UserId){
        int index = userId % length;  // 가장 초기에 시도 할 티켓 번호
        while(this->isEmpty(index) == true){ //사용된 티켓 번호라면 건너뛴다.
            index = (index + 1) % length; // 다음번호 조사
        }
        return index; // 사용되지 않은 인덱스를 찾아서 반환
    }

    void isEmpty(int ticketIndex){
        return this->used[ticketIndex];
        }

    void setUsed(int index, bool status){
        this->used[index] = status;
    }
};

vector<int> getTicketNumbers(int n, int m, const vector<int> &ids){
    vector<int> tickets;
    TicketTable table = TicketTable(n);
    for(int i=0; i<tickets.size(); i++){
    int userId = ids[i];
    int ticketIndex = table.findEmptyIndexByUserId(userId);
    ticket.push_back(ticketIndex);
    table.setUsed(ticketIndexx, true);
    }
    return tickets;
}

int main(){
    // n : 전체 티켓의 수
    //  m : 요청 고객의 수
    int n,m;
    scanf("%d%d",&n,&m);

    vector<int> ids(m);
    for(int i = 0; i < m; i++){
        scanf("%d",  &ids[i]);
    }
    vector<int> tickets = getTicketNumbers(n,m,ids);
    for(int i=0;i<tickets.size();i++){
        printf("%d\n",tickets[i]);
    }
    return 0;
}