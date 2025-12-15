package LLD_Design.creational.Prototype_DesignPattern.scaler;

public class client {



    public static void fillRegistry(studentRegistery str){
        // student template for apr22 batch
        Student apr22student = new Student();
        apr22student.setBatch("Apr22");
        apr22student.setAvgpspbatch(85.0);
        // inserting the template in the registry
        str.register("Apr22",apr22student);

        Student may22student = new Student();
        may22student.setBatch("May22");
        may22student.setAvgpspbatch(85.0);
        // inserting the template in the registry
        str.register("May22",may22student);
    }
    public static void main(String[] args){
        studentRegistery stRegistery= new studentRegistery();
        fillRegistry(stRegistery);

        Student stprototype =stRegistery.get("Apr22");
        Student rupali = stprototype.clone();
        rupali.setName("rupali");
        rupali.setAge(23);
        rupali.setStudentpsp(88.0);
        Student stprototype1 =stRegistery.get("May22");

        Student anchal = stprototype1.clone();
        anchal.setName("rupali");
        anchal.setAge(23);
        anchal.setStudentpsp(82.0);

        System.out.println("Debug");
    }
}
