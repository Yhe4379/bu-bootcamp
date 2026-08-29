public class Contact {
    private String name;
    private String phone;

    // 构造器:创建 Contact 时传入这两个值
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // getter:让外部读取私有字段
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // toString:决定这个对象被打印时长什么样
    @Override
    public String toString() {
        return name + " | " + phone;
    }
}