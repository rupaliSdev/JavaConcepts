package Basics.InterviewQues;

public class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj==null || getClass() !=obj.getClass())      {
            return false;
        }

        if(this==obj) {
            return true;
        }
        return this.getId()==((Employee)obj).getId();
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
