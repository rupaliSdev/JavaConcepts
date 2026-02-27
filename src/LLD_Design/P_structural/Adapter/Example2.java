package LLD_Design.P_structural.Adapter;

public class Example2 {
    public static void main(String[] args) {

    }
}
interface PaymentGateway {
    void pay(double amount);
}
class RazorpayClient {
     void makePayment(double amount){

     }
}
class RazorpayAdapter implements PaymentGateway {

    private RazorpayClient client = new RazorpayClient();

    public void pay(double amount) {
        client.makePayment(amount);
    }
}

/*
The Core Reason We Need Adapter

Because:

We want to use an existing class

But its interface does not match what client expects

        Adapter = interface converter*/
