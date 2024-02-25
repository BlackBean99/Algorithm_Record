package 멀쩡한사각형;

import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long ref = gcd(w,h);
        return ((long) w * h ) - (((w / ref) + (h/ref) -1) * ref);
    }
    
    private int gcd(int n, int m){
        while( m!= 0){
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}