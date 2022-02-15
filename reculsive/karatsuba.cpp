
// a+=b*(10^k)
void addTo(vector<int>& a, const vector<int>& b, int k);

void subForm(vector<int>& a, const vector<int>& b);

vector<int> karatsuba(const vector<int>& a, const vector<int>& b){
    int an = a.size();
    int bn = b.size();
    
    if(an<bn) return karatsuba(b,a);

    // a나 b가 비어있는 경우
    if(an == 0 || bn == 0 ) return vector<int>();

// 사이즈가 작으면 그냥 곱하는게 좋다
    if(an <= 50) return multiply(a,b);

    int half = an /2;

    vector<int> a0(a.begin(),a.begin() + half);
    vector<int> a1(a.begin() + half,a.end());
    vector<int> b0(b.begin(),b.begin() + min(b.size(), half));
    vector<int> b1(b.begin() + min(b.size(), half, b.end());

    vector<int> z2 = karatsuba(a1,b1);

    vector<int> z0 = karatsuba(a0,b0);

    addTo(a0,a1,0); addTo(b0,b1,0);

    z1 = karatsuba(a0,b0)

    subForm(z1,z0);
    subForm(z1,z2);

    vector<int> ret;

    addTo(ret, z0,0);
    addTo(ret,z1,half);
    addTo(ret,z2,half+half);

    return ret;