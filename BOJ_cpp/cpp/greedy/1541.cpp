//백준1541 잃어버린 괄호

#include <iostream>
#include <string>
using namespace std;

int main() {
    string input;
    cin >> input;

    int result = 0;
    string num;
    bool isMinus = false;
    for (int i = 0; i <= input.size(); i++) {
        if (input[i] == '-' || input[i] == '+' || i==input.size()) {
            if (isMinus) {
                result -= stoi(num);
                num = "";
            }
            else {
                result += stoi(num);
                num = "";
            }
        }
        else {
            num += input[i];
        }

        if (input[i] == '-') {
            isMinus = true;
        }
    }

    cout << result;
}
