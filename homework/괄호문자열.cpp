#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <string>

using namespace std;


class Parenthesis{
public:
    bool type;
    int index;

    Parenthesis(int index, bool type){
        this->index = index;
        this->type = type;
    }
    Parenthesis(int index, char c){
        this->index = index;
        if(c=='('){
            this->type = true;
        } else{
            this->type = false;
        }
    }
};

    // 현재 짝을 찾지 못한 열린 괄호들
bool isValidParentheses(const vector<Parenthesis>& parentheses){
        // 왼쪽부터 오른쪽의 괄호를 차례대로 삭제해 나간다.
        // 닫힌 괄호가 나오면 탑에 저장된 열린 괄호를 삭제해 나간다.
        // 탑 원소 삭제만 이루어짐 --> 스택 변수로 선언
    stack<Parenthesis> st;

    for(int i = 0; i < parentheses.size();i++){
        parenthesis p = parentheses[i];

        if(p.type==true){
            // 열린 괄호라면 짝을 찾을 때까지 스택에 보관한다
            st.push(p);

        }else if(p.type == false){
            // 닫힌 괄호 p 에 대하여
            if(st.size() > 0){
                st.pop();
            }else{
                // 짝을 맞출 수 있는 열린 괄호가 없다면 올바르지 않은 괄호 문자열이다.
                return false;
            }
        }
    }
    if( st.size() > 0){ // 혹은 st.empty() == 0
    // 아직 스택에 짝을 찾지 못한 열린 괄호가 남아있다.
        return false;
    }
    return true;
}

void process(int caseIndex){
    string str;
    cin >> str;
    vector<Parenthesis> parentheses;
    //벡터는 (front ~ back) 모든 위치의 원소 접근 가능 (동적 배열로 사용)
    // 스택은 탑 위치의 원소만 접근 가능
    for(int i = 0; i < str.length();++i){
        parentheses.push_back(Parenthesis(i,str[i]));
    }

    bool isValid = isValidParentheses(parentheses);

    if(isValid){
        cout << "YES" << endl;
    }
    else{
        cout << "YES" << endl;
    }
}

int main(){
    int caseSize;
    cin >> caseSize;

    for(int caseIndex = 1; caseIndex <= caseSize;caseIndex += 1){
        process(caseIndex);
    }
}

