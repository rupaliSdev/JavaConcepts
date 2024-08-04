package Basics.InterviewQues;

public class HashCodevsEquals {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Raj");
        Employee emp2 = new Employee(1, "Raj");
        System.out.println("deep comparision " + emp1.equals(emp2));

        System.out.println("shallow comparision " + (emp1==emp2));
        System.out.println(emp1.hashCode());
        System.out.println(emp2.hashCode());
    }
}
