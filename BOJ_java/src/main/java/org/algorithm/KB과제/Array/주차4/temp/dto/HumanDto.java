package org.algorithm.KB과제.Array.주차4.temp.dto;

// 항목들
public class HumanDto {
    // 이름, 나이, 전화번호, 주소, 메모     홍길동-24-123-강릉시-친구
    private String name;
    private int age;
    private String phone;
    private String address;
    private String memo;

//    public HumanDto() {
//    }


    public HumanDto(String name, int age, String phone, String address, String memo) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return name + "-"
                + age + "-"
                + phone + "-"
                + address + "-"
                + memo;
    }
}
