package Basics.comparatorss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee>lst = new ArrayList<>();
		lst.add(new Employee("rupali",90,70000));
		lst.add(new Employee("Nidhi",40,50000));
		lst.add(new Employee("Poorva",50,40000));

		Collections.sort(lst, (a,b)->{
			return a.getName().compareTo(b.getName());
		});

		
		Collections.sort(lst,new Comparator<Employee>() {
		public int compare(Employee a,Employee b) {
			return a.getId()-b.getId();
		}
		});
//		Collections.sort(st, new Comparator<Student>() {
//	    public int compare(Student a, Student b) {
//	        return a.getRoll_no()-b.getRoll_no();
//	    } 
//	 });
		System.out.println(lst);
		//comparable-used for single sorting
//		Collections.sort(lst,new Comparators());
		System.out.println(lst);
	}

}
