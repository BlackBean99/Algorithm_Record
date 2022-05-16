#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>


using namespace std;

class City{
    public:
        int index;
        int income;

        City(int index, int income){
            this->index = index;
            this->income = income;
        }
        // Class 의 대소관계 정의
        bool operator < (const City& o) const{
            return this->income < o.income;
        }
        bool operator > (const City& o) const{
            return this->income > o.income;
        }
};

int getMaximumRangeDifference(int n, int k, const vector<City>& cities){
    int answer = 0;
    // 소득이 가장 작은 도시부터 pop 되는 우선순위 큐
    priority_queue<City, vector<City> greater<City>> rangeMinmum;
    // 소득이 가장 높은 도시부터 pop되는 우선순위 큐  less인경우는 축소해서 사용이 가능하다.
    priority_queue<City> rangeMaximum;

    for(int i =0;i<k-1;i++){
        rangeMaximum.push(cities[i]);
        rangeMinimum.push(cities[i]);
    }
    for(int i=k-1;i<n;i++){
        rangeMaximum.push(cities[i]);
        rangeMinimum.push(cities[i]);
        while(rangeMaximum.top().index < i -k +1) rangeMaximum.pop();
        while(rangeMinimum.top().index < i -k +1) rangeMinimum.pop();
    }
        

}

void process(int caseIndex){
    int n,k;
    cin >> n >> k;
    vector<City> cities;

    for(int i = 0; i < n ; i +=1){
        int income;
        cin >> income;
        cities.push_back(City(i,income));
    }
    int answer = getMaximumRangeDifference(n,k,cities);
    cout << answer << endl;
}
int main(){
    int caseSize;
    cin >> caseSize;

    for(int caseIndex = 1; caseIndex <= caseSize; caseIndex+=1){
        process(caseIndex);
    }

}
