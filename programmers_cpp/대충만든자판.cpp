#include <iostream>
#include <vector>
#include <unordered_map>

int INT_MAX = 4321;

using namespace std;
vector<int> solution(vector<string> keymap, vector<string> targets) {
    // count occurrences of each character in all keymaps
    vector<int> charToKeyPressCount(26, INT_MAX);
    for (const string& km : keymap) {
        for (char c : km) {
            int presses = km.find(c) + 1;
            charToKeyPressCount[c - 'A'] = min(charToKeyPressCount[c - 'A'], presses);
        }
    }

    // calculate key presses for each target string
    vector<int> result;
    for (const string& target : targets) {
        int totalPresses = 0;
        for (char c : target) {
            int presses = charToKeyPressCount[c - 'A'];
            if (presses == INT_MAX) {  // character not found in any keymap
                totalPresses = -1;
                break;
            }
            totalPresses += presses;
        }
        result.push_back(totalPresses);
    }

    return result;
}