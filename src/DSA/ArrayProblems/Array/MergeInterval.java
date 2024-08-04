package DSA.ArrayProblems.Array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String dateString="2000-10-30";
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
//		// Parse the date string into a Date object
//		Date date = formatter.parse(dateString);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Parse the date string to a LocalDate object
		LocalDate date = LocalDate.parse(dateString, formatter);

		System.out.println(date);

	}


	public int[][] merge(int[][] intervals) {


		Arrays.sort(intervals,(a, b)-> Integer.compare(a[0],b[0]));

		List<int[]> res= new ArrayList<>();
		int[] prev=intervals[0];

		for(int i=1;i<intervals.length;i++){
			if(intervals[i][0]<prev[1]){
                prev[1]=intervals[i][1];
			}
			else{
				res.add(prev);
				prev=intervals[i];
			}
		}
		res.add(prev);

		return res.toArray(new int[res.size()][2]);
	}
}
