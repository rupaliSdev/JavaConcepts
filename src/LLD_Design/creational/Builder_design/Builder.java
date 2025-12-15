package LLD_Design.creational.Builder_design;

public class Builder {

     String name;
     double psp;
     int age;

     String universityname;
     String batch;
     long id;
     int gradyear;
     String phoneNo;

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    public int getGradyear() {
        return gradyear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGradyear(int gradyear) {
        this.gradyear = gradyear;
    }


}
