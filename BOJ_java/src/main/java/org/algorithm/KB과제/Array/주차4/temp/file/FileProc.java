package org.algorithm.KB과제.Array.주차4.temp.file;


import java.io.*;
import org.algorithm.KB과제.Array.주차4.temp.dto.HumanDto;
import org.algorithm.KB과제.Array.주차4.temp.single.Singleton;

public class FileProc {

    private File file;

    public FileProc(String filename) {
        file = new File("d:\\tmp\\" + filename + ".txt");

        try {
            if(file.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read()  {
        Singleton sc = Singleton.getInstance();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str;
            while((str = br.readLine()) != null){
                // str = 홍길동-24-123-강릉시-친구
                String arr[] = str.split("-");

                HumanDto dto = new HumanDto( arr[0],
                                             Integer.parseInt(arr[1]),
                                             arr[2],
                                             arr[3],
                                             arr[4]);

                sc.list.add(dto);
            }
            br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void write(){
        Singleton sc = Singleton.getInstance();
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            // str = 홍길동-24-123-강릉시-친구
            for(HumanDto dto : sc.list){
                pw.println(dto.toString());
            }
            pw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
