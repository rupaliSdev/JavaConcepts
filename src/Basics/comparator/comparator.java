package Basics.comparator;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Collections.*;

public class comparator {
	
	public static void main(String[] args) {
		ArrayList<movie> lst = new ArrayList<>();
		lst.add(new movie(2.3,"k3g",1999));
		lst.add(new movie(5,"chakde",2005));
		lst.add(new movie(6,"sholey",1960));
		sort(lst);
		System.out.println("Sorting by year");
		for(movie m:lst) {
			System.out.println(m.getName()+ " " + m.getRating()+ " "+ m.getYear());
		}
		
		System.out.println("Sort by rating");
		ratingCompare rc = new ratingCompare();
		sort(lst,rc);
		for(movie m:lst) {
			System.out.println(m.getName()+ " " + m.getRating()+ " "+ m.getYear());
		}
		
        System.out.println("Sort by name");
        nameCompare nc = new nameCompare();
		sort(lst,nc);
		for(movie m:lst) {
			System.out.println(m.getName()+ " " + m.getRating()+ " "+ m.getYear());
		}


	}

	static class nameCompare implements Comparator<movie> {

		@Override
		public int compare(movie o1, movie o2) {
			// TODO Auto-generated method stub

			return o1.getName().compareTo(o2.getName());

		}

	}

	static class movie implements Comparable<movie> {

		private double rating;
		private String name;
		private int year;

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public movie(double rating, String name, int year) {

			this.rating = rating;
			this.name = name;
			this.year = year;
		}

		@Override
		public int compareTo(movie o) {
			// TODO Auto-generated method stub
			return this.year - o.year;
		}

		@Override
		public String toString() {
			return "movie [rating=" + rating + ", name=" + name + ", year=" + year + "]";
		}

	}

	static class ratingCompare implements Comparator<movie> {

		@Override
		public int compare(movie m1, movie m2) {
			if (m1.getRating() < m2.getRating())
				return -1;
			if (m1.getRating() > m2.getRating())
				return 1;
			else
				return 0;
		}

	}
}

