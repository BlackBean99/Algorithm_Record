package org.algorithm.백트래킹.n_queen;


import java.io.*;


public class Main {
    public static int n;
    public static int[] board;
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[15];
        n_queen(0);
        System.out.println(count);
    }
    private static boolean validateNext(int level){
        for (int i = 0; i < level; i++) {
            if(board[level] == board[i] || level - i == Math.abs(board[level] - board[i])){
                return false;
            }            
        }
        return true;
    }
    private static void n_queen(int level){
        if(level == n){
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[level] = i;
            if(validateNext(level)){
                n_queen(level+1);
            }
        }
    }
    
}
