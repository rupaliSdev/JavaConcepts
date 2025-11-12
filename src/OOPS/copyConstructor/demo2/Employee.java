package OOPS.copyConstructor.demo2;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable{
     String name;
     Employee(String name){
     this.name= name;
     }
     public Object clone() throws CloneNotSupportedException {
        return super.clone();  // shallow copy for Employee
     }
}
class Department implements Cloneable{
    String depName;
    List<Employee> employees;
    public Department(String depName, List<Employee> employees) {
        this.depName = depName;
        this.employees = employees;
    }
    public Object shallowClone() throws CloneNotSupportedException{
        return super.clone();
    }

    // ---- Deep Copy ----
    public Object deepClone() throws CloneNotSupportedException {
        Department cloned = (Department) super.clone();
        List<Employee> clonedList = new ArrayList<>();
        for (Employee emp : employees) {
            clonedList.add((Employee) emp.clone());  // clone each Employee
        }
        cloned.employees = clonedList;
        return cloned;
    }
}