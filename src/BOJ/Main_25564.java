package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25564 {
    private static int K;

    private static boolean isVelen(String name){
        int length = name.length();
        for (int i = 0; i < length - K; i++) {
            for (int j = i+K; j < length; j++) {

            }
            name.substring(i,i+K);
        }
        if(isEmploedVelen()){

        }
        }
        return true;
    }

    private static boolean isEmploedVelen(String subName) {
        if (chars[i] == chars[length - i-1]) {
            continue;
        }

        else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a, " ");
        int index = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
//        Input 받기
        String text = br.readLine();
        int cnt = 0;
        for (int i = 0; i < index-K; i++) {
            for (int j = K; i + j < text.length(); j++) {
                String substring = text.substring(i, i + j);
                if(isVelen(substring)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
