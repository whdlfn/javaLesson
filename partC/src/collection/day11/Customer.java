package collection.day11;

// 고객정보 클래스
public class Customer {
    private String name;
    private String phone;
    private int group;          //1이면 일반 2: vip 3:기타

    public Customer(String name, String phone, int group) {
        this.group=group;
        this.name=name;
        this.phone=phone;
    }


    public int getGroup() {
        return group;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    // 정보변경 메소그
    public void modify(String phone, int group){
        this.group=group;
        this.phone=phone;
    }


    @Override
    public String toString() {
        return "Customer [name=" + name + ", phone=" + phone + ", group=" + group + "]";
    }

    



}
