package Models.AbstractClass;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected boolean gender; //1:Nam 0:Nữ

    public Person() {
    }

    public Person(int id, String name, int age, boolean gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public abstract void introduceYourself(String name);
}
