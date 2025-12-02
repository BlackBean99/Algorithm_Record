import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int h;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        Arrays.sort(arr);
        int left = 0;
        int right = max;
        while(left <= right){
            int mid = (right + left) / 2;
            if(calcLeftTree(mid) >= h){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
    static long calcLeftTree(int cut) {
        long total = 0;
        for (int tree : arr) {
            if (tree > cut)
                total += (tree - cut);
        }
        return total;
    }
}