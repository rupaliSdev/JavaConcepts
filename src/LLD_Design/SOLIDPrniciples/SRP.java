package LLD_Design.SOLIDPrniciples;


/*The Single Responsibility Principle (SRP) states that every class or module in a software system should  have  only  one  responsibility,  i.e.,
 only  one  reason  to  change.  This  means  that  a  class  or module  should  have  a  well-defined  and  narrow  purpose,  and
 it  should  not  be  responsible  for multiple unrelated tasks.*/

//example 1
public class SRP {

    static class TransactionHandler{
        EmailSender emailSender;

        public void handleTransaction(){
            //

            emailSender.sendEmail();
        }

    }
    static class EmailSender{

        public void sendEmail() {

        }
    }
    public static void main(String[] args) {


    }
}
//example 2

  class  PayStubGenerator  {
        public  String  generatePayStub(String  employeeName,  double  grossPay,
                                        double  netPay)  {
            StringBuilder  sb  =  new  StringBuilder();
            sb.append("Pay  Stub  for  "  +  employeeName  +  "\n");
            sb.append("Gross  Pay:  $"  +  grossPay  +  "\n");
            sb.append("Net  Pay:  $"  +  netPay  +  "\n");
            return  sb.toString();
        }
}
       /* In this example, the PayStubGenerator class has a single responsibility, which is to generate pay stubs  for  each  employee  based  on  their  gross  pay  and  net  pay.  This  means  that  if  you  need  to modify the pay stub generation logic, you only need to change the generatePayStub method, and not any other parts of the class.
        Finally, you could have a PayrollService class that coordinates the different responsibilities of the payroll processing. Here's an example implementation:
      */
       class  PayrollService {
           private SalaryCalculator salaryCalculator;
           private PayStubGenerator payStubGenerator;

           public String PayrollService(SalaryCalculator salaryCalculator, PayStubGenerator
                   payStubGenerator) {
               this.salaryCalculator = salaryCalculator;
               this.payStubGenerator = payStubGenerator;
     /*           double  grossPay  = salaryCalculator.calculateGrossPay(employee.getHourlyRate(), employee.getHoursWorked());
                double  netPay  =  salaryCalculator.calculateNetPay(grossPay, employee.getTaxRate());
                String  payStub  =  payStubGenerator.generatePayStub(employee.getName(), grossPay,  netPay);
                return  payStub;*/
               return null;
           }

            class SalaryCalculator {
               public double calculateGrossPay(double hourlyRate, int hoursWorked) {
                   return hourlyRate * hoursWorked;
               }

               public double calculateNetPay(double grossPay, double taxRate) {
                   return grossPay * (1 - taxRate);
               }
           }
       }