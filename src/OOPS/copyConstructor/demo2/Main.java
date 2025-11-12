package OOPS.copyConstructor.demo2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Alice"));
        empList.add(new Employee("Bob"));

        Department d1 = new Department("Engineering", empList);
        Department d2 = (Department) d1.shallowClone();

        // Modify employee name in cloned department
        d2.employees.get(0).name = "Charlie";

        System.out.println(d1.employees.get(0).name); // Charlie ❗ same list reference
        System.out.println(d2.employees.get(0).name); // Charlie


        List<Employee> empList1 = new ArrayList<>();
        empList.add(new Employee("Alice"));
        empList.add(new Employee("Bob"));

        Department d11 = new Department("Engineering", empList1);
        Department d21 = (Department) d1.deepClone();

        // Modify employee name in cloned department
        d21.employees.get(0).name = "Charlie";

        System.out.println(d11.employees.get(0).name); // Alice ✅ unaffected
        System.out.println(d21.employees.get(0).name); // Charlie
    }
}
