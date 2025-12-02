import java.util.*;
import java.io.*;

public class Main{
    static int answer;
    public static void main(String[] args){
        answer = 0;
        BufferedReader br = new BufferedReader(System.in);
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);

        int[] vips = new int[m];

        
        for(int i = 0; i < m; i++){
            vips[i] = Integer.parseInt(br.readLine());            
        }
        dfs(vips,visited);
        System.out.print(answer);
    }
    private void dfs(int[] vips, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        
        // List<Integer> initValue =  new int[]{};
        int[] initValue =  new int[visited.length + 1]{};
        Arrays.fill(initValue, -1);

        for(int vip: vips){
            initValue[vip] = vip;
        }

        q.add(initValue);

        while(!q.isEmpty()){
            int[] cur = queue.poll();
            if(isFull(cur)){
                answer++;
                continue;
            }
            int[] temp = Arrays.copyOf(cur, cur.length);
            
            for(int i = 1; i <= n; i++){
                if(i - 1 >= 0 ){
                    if(temp[i-1] == -1){
                        temp[i-1] = i;
                        queue.add(temp);
                    }
                }
                if(i + 1 <= n){
                    if(temp[i+1] == -1){
                        temp[i+1] = i;
                        queue.add(temp);
                    }
                }
                if(temp[i] == -1){
                    temp[i] = i;
                    queue.add(temp);
                }
            }
        }
    }
    private boolean isFull(int[] arr){
        for(int a: arr){
            if(a == -1) return false;
        }
        return true;
    }
}