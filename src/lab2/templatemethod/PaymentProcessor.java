package lab2.templatemethod;

public abstract class PaymentProcessor {

  // template method
  protected void processPayment(
      double amount,
      String currency,
      String paymentType,
      Customer customer,
      VisaCard visaCard,
      String paypalAddress) {
    double dollarAmount = amount;

    if (currency.contentEquals("EUR")) { // European Euro
      dollarAmount = amount * 1.1;
      System.out.println("Convert " + amount + " " + currency + " to US dollars");
    }
    if (currency.contentEquals("INR")) { // Indian Rupee
      dollarAmount = amount * 0.014;
      System.out.println("Convert " + amount + " " + currency + " to US dollars");
    }

    validate(paymentType, customer, visaCard, paypalAddress, dollarAmount);
  }

  public abstract void validate(
      String paymentType,
      Customer customer,
      VisaCard visaCard,
      String paypalAddress,
      double dollarAmount);
}
