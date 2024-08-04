package JDBC_Demo.jdbc;

import java.sql.*;
import java.util.Scanner;

public class HandsOn1_Book {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		.Class.forName("oracle.jdbc.driver.OracleDriver");//type of  driver and database name
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/demo","postgres","Rup#1904");
		
		Scanner s= new Scanner(System.in);
			
		int cont = 1;
		
		while(true) {
		if(cont == 1) {
		System.out.println("Enter your choice : \n I/i - Insert \n U/u - Update \n D/d - Delete \n S/s - Display");
		String choice = s.next();
		
		switch(choice) {
		case "I" : 
		case "i" :
			System.out.println("------------Insert Values----------");
			System.out.println("Enter Book Id");
			int bookid=s.nextInt();
			System.out.println("Enter the Name of the Book");
			String bookname=s.next();
			System.out.println("Enter the Name of the Author");
			String authname=s.next();
			System.out.println("Enter the Name of the Publisher");
			String pubname=s.next();
			System.out.println("Enter the Price");
			int bprice=s.nextInt();
			
			String str="insert into book_details values('"+bookid+"','"+bookname+"','"+authname+"','"+pubname+"','"+bprice+"')";
			Statement st1=con.createStatement();
			int i=st1.executeUpdate(str);
			if(i!=0) {
				System.out.println("Your record has been Inserted successfully");
			}
			else {
				System.out.println("Sorry, No operations performed!!");
			}
			break;
			
		case "U" :
		case "u" :
			System.out.println("-------Update the Price----------");
			System.out.println("Enter Book Id");
			bookid=s.nextInt();
			System.out.println("Enter New Price");
			bprice=s.nextInt();
			
			String s1= "update book_details set price=? where book_id=?";
			
			PreparedStatement pst=con.prepareStatement(s1);
			pst.setInt(1, bprice);
			pst.setInt(2, bookid);
			
			i = pst.executeUpdate();
			if(i!=0) {
				System.out.println(" Record has been updated successfully!!");
			}
			else {
				System.out.println("Sorry, No operations performed!!");
			}
			break;
			
		case "D" :
		case "d" :
			System.out.println("-------Delete the Record----------");
			System.out.println("Enter Book Id");
			bookid=s.nextInt();
			
			String s2= "delete book_details where book_id=?";
			
			PreparedStatement delete_pst = con.prepareStatement(s2);
			delete_pst.setInt(1, bookid);
			
			i = delete_pst.executeUpdate();
			if(i!=0) {
				System.out.println(" Record has been deleted successfully!!");
			}
			else {
				System.out.println("Sorry, No operations performed!!");
			}
			break;
			
		case "S" :
		case "s" :
			String q= "Select * from book_details";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(q);
			System.out.println("Book ID \t Book Name \t Author Name \t Publisher Name \t Price");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t \t ");
				System.out.print(rs.getString(2)+"\t \t ");
				System.out.print(rs.getString(3)+"\t \t ");
				System.out.print(rs.getString(4)+"\t \t \t ");
				System.out.print(rs.getInt(5)+"\t \t ");
				System.out.println();
			}
			break;
		
		default :
			System.out.println("You entered wrong choice!");
			break;
		}
		
		
		System.out.println("Do you want to perform more operations? \n Y-1/N-2");
		cont = s.nextInt();
		}
		else {
			System.out.println("Program has ended");
			break;
		}
	}
		
	}

}
