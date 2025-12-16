package ExceptionHandelling.UserDefinedEception;

import java.util.Scanner;

public class StatusException {
    public static void main(String[] args) throws MaritalStatus {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your marital status! \n Married - 'm/M' \n Single - 's/S' \n Divorcee -'d/D'");
        String s = sc.next();
        switch(s){
            case "s":
            case "S":
                System.out.println("Your status is single");break;
            case "M":
            case "m":
                System.out.println("Your status is Married");break;
            case "D":
            case "d":
                System.out.println("Your status is Divorcee");break;
            default:
                throw new MaritalStatus(s);
        }

    }

    static class MaritalStatus extends Exception{

       String status;

        public MaritalStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "MaritalStatus '"+status +"'is invalid";
        }
    }
}

