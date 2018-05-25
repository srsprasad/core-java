package org.surthi.app.concurrent.forkjoin;

public class MemberWrapper {
    private Member member;
    private int daysSinceRegistered;
    private int age;

    public MemberWrapper(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getDaysSinceRegistered() {
        return daysSinceRegistered;
    }

    public void setDaysSinceRegistered(int daysSinceRegistered) {
        this.daysSinceRegistered = daysSinceRegistered;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberWrapper{" +
                "member=" + member +
                ", daysSinceRegistered=" + daysSinceRegistered +
                ", age=" + age +
                '}';
    }
}
