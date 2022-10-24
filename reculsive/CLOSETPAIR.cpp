#include <vector>


bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.first == b.first) {
		return a.second < b.second;
	}
	else {
		return a.first < b.first;
	}
}

int closetPair(vector<pair<int,int>> S){
    // x 기준으로 오름차순 정렬
    int mid = S.size() / 2;
    vector<pair<int,int>> Cl = std::vector<pair<int,int>> slice(S.begin(),S.begin() + mid);
    vector<pair<int,int>> Cr = std::vector<pair<int,int>> slice(S.mid()+1,S.end());
    
    if(i<=3) return (2개, 3개 점들 사이의 최근점 쌍)
    closetPair(Cl);
    closetPair(Cr);
    vector<pair<int,int>> tmp;
    tmp.push_back(Cl.end());
    tmp.push_back(Cr.first());
    int Cc = dist(Cl.end(),Cr.first());
    return min(dist(Cl),dist(Cr),dist(tmp));
}

int main(void){
    sort(v.begin(), v.end(), compare);
    closePair(v);
    for(auto i : v){
        cout << v[i];
    }
}