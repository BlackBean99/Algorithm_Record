import java.util.*;
import java.io.*;

class Main {
    static int[] num, target;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        int[] answer = new int[m];
        int[] target = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i ++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i = 0; i < m; i++){
            answer[i] = getLowerBound(target[i]) - getUpperBound(target[i]);
            System.out.print(answer[i] + " " );
        }


    }
    static int getLowerBound(int target){
        int lo = 0;
        int hi = num.length;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(num[mid] <= target){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    
    static int getUpperBound(int target){
        int lo = 0;
        int hi = num.length;
        while(lo < hi){
            int mid = (lo + hi) /  2;
            if(num[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
