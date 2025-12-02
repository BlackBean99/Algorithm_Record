import java.util.*;
import java.io.*;

public class Main {
    static int n,x;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        int answer = 0;
        Arrays.sort(arr);
        for(int i = 0; i < n-1; i++){
            if(arr[i] > x) break;
            for(int j=i+1; j < n; j++){
                if(arr[i] + arr[j] > x){
                    break;
                } else if(arr[i] + arr[j] == x){
                    answer++;
                    break;                    
                }
            }
        }
        System.out.println(answer);
    }
}
