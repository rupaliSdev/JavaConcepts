package LLD_Design.P_structural.Bridge;

public class BridgeDemo {
    public static void main(String[] args) {

        Payment stripeCreditCard =
                new CreditCardPayment(new StripeProcessor());

        stripeCreditCard.pay(5000);

        System.out.println("------------");

        Payment razorpayUPI =
                new UPIPayment(new RazorpayProcessor());

        razorpayUPI.pay(2000);
    }
}
/*
🎯 Problem

We have 2 dimensions:

        1️⃣ Payment Type (What)

CreditCardPayment

        UPIPayment

2️⃣ Payment Processor (How)

Stripe

        Razorpay

If we combine directly ❌

StripeCreditCardPayment

        StripeUPIPayment

RazorpayCreditCardPayment

        RazorpayUPIPayment

Class explosion 🚨

        ✅ Bridge Solution

We separate:

Abstraction → Payment

Implementation → PaymentProcessor

And connect them via composition

            Payment (Abstraction)
                   |
     -----------------------------
     |                           |
CreditCardPayment        UPIPayment

            |
            |  (Bridge via composition)
            ↓
     PaymentProcessor (Implementation)
            |
     --------------------
     |                  |
StripeProcessor   RazorpayProcessor.*/
interface PaymentProcessor {
    void process(double amount);
}
class StripeProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing ₹" + amount + " via Stripe");
    }
}
class RazorpayProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing ₹" + amount + " via Razorpay");
    }
}
abstract class Payment {

    protected PaymentProcessor processor;

    public Payment(PaymentProcessor processor) {
        this.processor = processor;
    }

    abstract void pay(double amount);
}
class CreditCardPayment extends Payment {

    public CreditCardPayment(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    void pay(double amount) {
        System.out.println("Initiating Credit Card Payment...");
        processor.process(amount);
    }
}
class UPIPayment extends Payment {

    public UPIPayment(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    void pay(double amount) {
        System.out.println("Initiating UPI Payment...");
        processor.process(amount);
    }
}