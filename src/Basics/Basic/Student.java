package Basics.Basic;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
        this.id = 0;
        this.name = "Rupali";
    }

    public  void  display(){
        System.out.println("Id: "+id+" Name: "+name);
    }



}
