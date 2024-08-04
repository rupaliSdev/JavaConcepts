package LLD_Design.Prototype_DesignPattern.scaler;

public class Student implements prototype {

    private String name;

    private int age ;
    private double studentpsp;

    private double avgpspbatch;
    //should be private
    private String batch;


    @Override
    public Student clone() {
        Student st = new Student();
        st.avgpspbatch=this.avgpspbatch;
        st.batch=this.batch;
        return st;
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

    public double getStudentpsp() {
        return studentpsp;
    }

    public void setStudentpsp(double studentpsp) {
        this.studentpsp = studentpsp;
    }

    public double getAvgpspbatch() {
        return avgpspbatch;
    }

    public void setAvgpspbatch(double avgpspbatch) {
        this.avgpspbatch = avgpspbatch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
