package org.algorithm.KB과제.Array.주차4.temp.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.algorithm.KB과제.Array.주차4.temp.dto.HumanDto;
import org.algorithm.KB과제.Array.주차4.temp.single.Singleton;

public class AddressDao {

    Scanner sc = new Scanner(System.in);

    // list
//    private ArrayList<HumanDto> list;

    public AddressDao() {
//        list = new ArrayList<HumanDto>();
    }

    // CRUD
    public void insert(){
        System.out.println("지인을 추가합니다");

        System.out.print("이름 = ");
        String name = sc.next();

        System.out.print("나이 = ");
        int age = sc.nextInt();

        System.out.print("전화번호 = ");
        String phone = sc.next();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("주소 = ");
        String address = "";
        try {
            address = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("메모 = ");
        String memo = "";
        try {
            memo = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Singleton s = Singleton.getInstance();
        s.list.add(new HumanDto(name, age, phone, address, memo));
    }
    public void delete(){
        System.out.print("삭제할 지인의 이름 = ");
        String name = sc.next();

        int index = search(name);
        if(index == -1){
            System.out.println("지인의 정보를 찾을 수 없습니다");
            return;
        }

        Singleton s = Singleton.getInstance();
        HumanDto dto = s.list.get(index);
        s.list.remove(index);
        System.out.println(dto.getName() +  "님의 정보를 삭제하였습니다");

    }
    public void select(){
        Singleton s = Singleton.getInstance();

        System.out.print("검색할 지인의 이름 = ");
        String name = sc.next();

        ArrayList<HumanDto> findList = new ArrayList<HumanDto>();

        // 동명이인이 있을 경우를 생각해서 새로운 리스트에 추가
        for (HumanDto h : s.list){
            if(name.equals(h.getName())){
                findList.add(h);
            }
        }

        if(findList.size() == 0){
            System.out.println("지인의 정보를 찾을 수 없습니다");
            return;
        }

        for (HumanDto h : findList){
            System.out.println(h.toString());
        }
    }
    public void update(){
        System.out.print("수정할 지인의 이름 = ");
        String name = sc.next();

        int index = search(name);
        if(index == -1){
            System.out.println("지인의 정보를 찾을 수 없습니다");
            return;
        }

        System.out.print("전화번호 = ");
        String phone = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("주소 = ");
        String address = "";
        try {
            address = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Singleton s = Singleton.getInstance();
        HumanDto human = s.list.get(index);
        human.setPhone(phone);
        human.setAddress(address);

        System.out.println("정상적으로 수정되었습니다");
    }

    // 검색하는 함수(utility)
    public int search(String name){
        Singleton s = Singleton.getInstance();
        int index = -1;
        for (int i = 0;i < s.list.size(); i++){
            HumanDto dto = s.list.get(i);
            if(name.equals(dto.getName())){
                index = i;
                break;
            }
        }
        return index;
    }

    // All
    public void all(){
        Singleton s = Singleton.getInstance();
        for (HumanDto h : s.list){
            System.out.println(h.toString());
        }
    }

}
