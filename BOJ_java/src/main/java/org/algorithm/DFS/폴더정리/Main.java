package org.algorithm.DFS.폴더정리;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int diff;
    static int many;

    static class Folder {

        String name;
        ArrayList<Folder> child = new ArrayList<>();
        ArrayList<String> file = new ArrayList<>();

        Folder() {}

        Folder(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        Folder root = new Folder("main");
        ArrayList<Folder> folder = new ArrayList<>();
        folder.add(root);
        HashMap<String, Integer> indexFolder = new HashMap<>();
        indexFolder.put("main", 0);
        for (int i = 0; i < N + M; i++) {
            strs = br.readLine().split(" ");
            String P = strs[0];
            String F = strs[1];
            int C = Integer.parseInt(strs[2]);

            // 폴더일 경우
            if (C == 1) {
                Folder now = null;
                // 기존에 있는 폴더인지 확인
                for (int j = 0; j < folder.size(); j++) {
                    if (folder.get(j).name.equals(F)) {
                        now = folder.get(j);
                    }
                }
                if (now == null) {
                    now = new Folder(F);
                    folder.add(now);
                    indexFolder.put(F, folder.size() - 1);
                }

                Folder parent = null;
                // 부모가 없으면?
                if (indexFolder.get(P) == null) {
                    parent = new Folder(P);
                    folder.add(parent);
                    indexFolder.put(P, folder.size() - 1);
                } else {
                    // 부모가 있으면?
                    int index = indexFolder.get(P);
                    parent = folder.get(index);
                }
                parent.child.add(now);
            } else if (C == 0) {
                // 폴더일 경우
                Folder parent = null;
                // 폴더를 일단 생성해주자.
                if (indexFolder.get(P) == null) {
                    parent = new Folder(P);
                    indexFolder.put(P, indexFolder.size() - 1);
                    folder.add(parent);
                } else {
                    int index = indexFolder.get(P);
                    parent = folder.get(index);
                }
                parent.file.add(F);
            }
        }
        print(indexFolder, folder);
    }

    private static void print(HashMap<String, Integer> indexFolder, ArrayList<Folder> folder)
            throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strs;
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            many = 0;
            HashSet<String> diff = new HashSet<>();
            strs = br.readLine().split(" ");
            int index = indexFolder.getOrDefault(strs[strs.length - 1], -1);
            if (index == -1) {
                continue;
            } else {
                Folder find = folder.get(index);
                findFolder(find, diff);
                System.out.println(diff.size() + " " + many);
            }
        }
    }

    private static void findFolder(Folder find, HashSet<String> diff) {
        many += find.file.size();
        for (String s : find.file) {
            diff.add(s);
        }
        if (find.child.size() != 0) {
            for (Folder f : find.child) {
                findFolder(f, diff);
            }
        }
    }
}
