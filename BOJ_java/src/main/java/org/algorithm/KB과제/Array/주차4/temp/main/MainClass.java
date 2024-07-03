package org.algorithm.KB과제.Array.주차4.temp.main;


import java.util.Scanner;
import org.algorithm.KB과제.Array.주차4.temp.dao.AddressDao;
import org.algorithm.KB과제.Array.주차4.temp.file.FileProc;

public class MainClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileProc fp = new FileProc("addressBook");
        AddressDao dao = new AddressDao();
        fp.read();

        // menu
        while (true){
            System.out.println(" << 주소록 >> ");
            System.out.println("1. 지인추가");
            System.out.println("2. 지인삭제");
            System.out.println("3. 지인검색");
            System.out.println("4. 지인수정");
            System.out.println("5. 모두출력");
            System.out.println("6. 데이터 저장하기");

            System.out.print(">> ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    dao.insert();
                    break;
                case 2:
                    dao.delete();
                    break;
                case 3:
                    dao.select();
                    break;
                case 4:
                    dao.update();
                    break;
                case 5:
                    dao.all();
                    break;
                case 6:
                    fp.write();
                    break;
            }
        }

    }
}


