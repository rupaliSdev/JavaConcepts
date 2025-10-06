package DSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookAllocation {
/*
    n = 4, m = 2, arr[] = {12, 34, 67, 90}


      minPages = 90, maxPages = 203
      student =1
      mid = 293/2 = 146
      pageStudent = 0
      if (pageStudent +arr[i]<pagesPerStudent)
      {
          pageStudent +=arr[i];
      }
      else{
      student++
        pageStudent = arr[i];
      }


Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
Allocate books in such a way that:

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1




    */


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = allocateBook(arr, n, m);
        System.out.println("The answer is: " + ans);

    }

    public static int allocateBook(ArrayList<Integer> arr, int n, int m) {

        if (m > n) {
            return -1;
        }

        int min = Collections.max(arr);
        int max = arr.stream().mapToInt(Integer::intValue).sum();


        while (min <= max) {
            int mid = (min + max) / 2;

            if (findStudentsCount(arr, mid) > m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;

    }

    private static int findStudentsCount(ArrayList<Integer> arr, int mid) {
        int student = 1;
        int pagesStudent = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (pagesStudent + arr.get(i) <= mid) {
                pagesStudent += arr.get(i);
            } else {
                student++;
                pagesStudent = arr.get(i);
            }
        }
        return student;
    }

}
