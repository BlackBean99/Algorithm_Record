bool match(const string& w, const string& s){
    while(pos < w.size() && pos < w.size() && w[pos] == '?'||w[pos] == s[pos])
        pos++
    if(pos == s.size()) return pos == s.size();

    if(w[pos] == '*'){
        for(int skip = 0; pos + skip <= s.size(); ++skip){
            if(match(w.substr(pos+1),s.substr(pos+skip)))
                return true;
        }
        return false;
    }
}