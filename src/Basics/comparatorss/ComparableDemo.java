package Basics.comparatorss;

import java.util.*;

public class ComparableDemo {

	public static void main(String[] args) {

        ArrayList<Student> st = new ArrayList<>();
		Student s1 = new Student(20,14,"rohan");
		Student s2 = new Student(21,14,"rahul");
		Student s3 = new Student(19,14,"reena");
		
		st.addAll(Arrays.asList(s1,s2,s3));

		//by default sort by age as defined in the student class
		Collections.sort(st);

		//sort by student roll no custom

/*		The Comparator interface is used to define multiple ways of sorting objects.
		Java 8 introduced default and static methods to make it easier to chain and
		create comparators*/
		Collections.sort(st, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getRoll_no()-o2.getRoll_no();
			}
		});

		st.forEach(s->System.out.println(s.getName()));

		List<String> names = Arrays.asList("John", "Jane",
				"Jack", "Doe");

		names.sort(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase));

		System.out.println(names);
	}

	//comparable
	/*The Comparable interface is used to define the natural ordering of objects. It has
	a single method, compareTo, which compares the current object with another
	object of the same type*/

	static class Student implements Comparable<Student>{
		private int roll_no ;
		private int age;
		private String name;

		public Student(int roll_no, int age, String name) {
			this.roll_no = roll_no;
			this.age = age;
			this.name = name;
		}

		public int getRoll_no() {
			return roll_no;
		}

		public void setRoll_no(int roll_no) {
			this.roll_no = roll_no;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Student o) {
			return this.age-o.age;
		}
	}


	//comparator


	static class Comparators implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.getAge()-o2.getAge();
		}

	}
}
