package org.algorithm.KB과제.Array.주차3.Q2;

public class Superman extends Man{

    public Superman(int age, String name, int power, boolean sky) {
        super(age, name, power);
        this.sky = sky;
    }

    private boolean sky;
    public void space() {
        System.out.println(super.name + "이(가) 우주를 날아갑니다.");
    }
    @Override
    public void run() {
        super.run();
        space();
        System.out.println(this);
    }

    @Override
    public String toString() {
        return (sky ? "슈퍼맨 " : "일반인 ") +
            super.toString() +
            ", sky=" + sky +
            ']';
    }
}
