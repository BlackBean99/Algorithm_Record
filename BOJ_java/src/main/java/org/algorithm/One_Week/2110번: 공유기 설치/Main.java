import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int n;
    static int c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0;i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        int lo = 1;
        int hi = arr[arr.length-1] - arr[0] + 1;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(canInstall(mid) < c){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo-1);
    }
    
    static int canInstall(int dist){
        int count = 1;
        int locate = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - locate < dist){
                continue;
            } else {
                count++;
                locate = arr[i];
            }
        }
        return count;
    }
}
