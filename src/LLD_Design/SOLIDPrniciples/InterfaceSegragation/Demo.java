package LLD_Design.SOLIDPrniciples.InterfaceSegragation;

public class Demo {
   /* Interface Segregation Principle:
            ● "No client should be forced to depend on methods it does not use" ● One fat interface needs to be split into many smaller and relevant interfaces so that clients
            can know about the interfaces that are relevant to them
            The  Interface  Segregation  Principle  (ISP)  states  that  clients  should  not  be  forced  to  depend  on interfaces they do not use. In simpler terms, it means that a client should only be exposed to the methods it needs and not to methods it doesn't need.
*/

    public  interface  Printer  {
        void  print();
        void  scan();
        void  fax (); }
//    Let's say we have a class Document that needs to use the print() method only. So we implement the Printer interface in the Document class as follows:
    public  class  Document  implements  Printer  {
        @Override
        public  void  print()  {                System.out.println("Printing  the  document...");        }
        @Override        public  void  scan()  {                //  Nothing  to  do  here
        }
        @Override public  void  fax()  {        }
    }

}

//better Approach

interface  Printable  {
    void  print();
}
interface  Scannable  {
    void  scan();
}
interface  Faxable  {
    void  fax ();
}