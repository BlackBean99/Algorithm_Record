package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        String str;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                
            }
        }
        while( (str=br.readLine()) != null ){
            st = new StringTokenizer(str," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
    }
}
